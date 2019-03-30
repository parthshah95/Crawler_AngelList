import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompanyScrap {

   public class CompanyFilter {

        @SerializedName("ids")
        private List<Integer> mIds;

        @SerializedName("hexdigest")
        private String mDigest;

        @SerializedName("total")
        private String mTotalCount;

        @SerializedName("page")
        private int mPage;

        @SerializedName("sort")
        private String mSort;

        @SerializedName("new")
        private boolean mNew;

        public List<Integer> getIds() {
            return mIds;
        }

        public String getDigest() {
            return mDigest;
        }

        public String getTotalCount() {
            return mTotalCount;
        }

        public int getpage() {
            return mPage;
        }

        private String buildRequest() {
            String out = "total=" + mTotalCount + "&";
            out += "sort=" + mSort + "&";
            out += "page=" + mPage + "&";
            out += "new=" + mNew + "&";
            for (int i = 0; i < mIds.size(); i++) {
                out += "ids[]=" + mIds.get(i) + "&";
            }
            out += "hexdigest=" + mDigest + "&";
            
           
            return out;
        }
    }
   
    public static List<Company> getCompanies(final CompanyFilter companyFilter) throws IOException {

    	 List<Company> companies = new ArrayList<>();

         Element doc = Jsoup.connect("https://angel.co/companies/startups?" + companyFilter.buildRequest())
                 .userAgent("Mozilla")
                 .ignoreContentType(true)
                 .get().body();
         Elements data = doc.select("div[data-_tn]");

        if (data.size() > 0) {
            for (int i = 2; i < data.size(); i++) {
                companies.add(new Company(data.get(i).select("a[data-type]").text(),
                        data.get(i).select("a").first().attr("href").replace("\\\"", ""),
                        data.get(i).select("div.pitch").first().text().replace("\\n", ""),
                		data.get(i).select("div.value").get(1).text().replace("\\n", ""),
                		data.get(i).select("div.value").get(2).text().replace("\\n", ""),
                		data.get(i).select("div.value").get(3).text().replace("\\n", ""),
                		data.get(i).select("div.value").get(4).text().replace("\\n", ""),
                		data.get(i).select("div.value").get(5).text().replace("\\n", ""),
                		data.get(i).select("div.value").get(6).text().replace("\\n", ""),
                		data.get(i).select("div.value").get(7).text().replace("\\n", "")));
            }

        } else {
            System.out.println("no data");
        }
        
      
        return companies;
    }

    /**
     * Return company filter object
     */
    private static CompanyFilter getCompanyFilter(final String filter, final int page) throws IOException {

        String response = Jsoup.connect("https://angel.co/company_filters/search_data")
                .header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
                .header("X-Requested-With", "XMLHttpRequest")
                .data("filter_data[company_types][]=", filter)
                .data("sort", "signal")
                .data("page", String.valueOf(page))
                .userAgent("Mozilla")
                .ignoreContentType(true)
                .post().body().text();
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.fromJson(response, CompanyFilter.class);
    }
    public static List<Company> getall() throws IOException{
    	 int pageCount = 1;
         List<Company> companies = new ArrayList<>();
        CompanyFilter companyFilter = null;
         for (int i = 0; i < 20; i++) {
			try {
				companyFilter = getCompanyFilter("Startup", pageCount);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             pageCount++;

             companies.addAll(getCompanies(companyFilter));
             

             if (companies.size() == 0) {
                 break;      
             } 
         }
    	return companies;
    }
}
