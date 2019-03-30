public class Company {

        private String mLink;
        private String mName;
        private String mDescription;
        private String joined;
        private String location;
        private String market;
        private String website;
        private String employees;
        private String stage;
        private String total_raised;

        public Company(String name, String link, String description,String join_Date,String loc, String market_name,String webst, String empl, String stg,String total) {
            mLink = link;
            mName = name;
            mDescription = description;
            joined = join_Date;
            location = loc;
            market =market_name;
            website = webst;
            employees = empl;
            stage= stg;
            total_raised = total;
        }

        public String getLink() {
            return mLink;
        }

        public String getName() {
            return mName;
        }

        public String getDescription() {
            return mDescription;
        }
        
        public String getjoindate() {
            return joined;
        }
        
        public String getlocation() {
            return location;
        }
        
        public String getmarket() {
            return market;
        }

        public String getwebsite() {
        	return website;
        }
        
        public String getemployees() {
            return employees;
        }
        
        public String getstage() {
            return stage;
        }
        
        public String gettotal() {
            return total_raised;
        }
    }
