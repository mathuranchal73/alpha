/**
 * 
 */
package com.alpha.dto;

/**
 * @author Anchal.Mathur
 *
 */
public class GeoLocation {
	
	 	private String countryCode;
	    private String countryName;
	    private String postalCode;
	    private String city;
	    private String region;
	    private String latitude;
	    private String longitude;
	    
	    
		public GeoLocation(String countryCode, String countryName, String postalCode, String city, String region,
				 String latitude, String longitude) {
			super();
			this.countryCode = countryCode;
			this.countryName = countryName;
			this.postalCode = postalCode;
			this.city = city;
			this.region = region;
			this.latitude = latitude;
			this.longitude = longitude;
		}


		@Override
		public String toString() {
			return "GeoLocation [countryCode=" + countryCode + ", countryName=" + countryName + ", postalCode="
					+ postalCode + ", city=" + city + ", region=" + region + ", latitude=" + latitude + ", longitude=" + longitude
					+ "]";
		}


		public String getCountryCode() {
			return countryCode;
		}


		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}


		public String getCountryName() {
			return countryName;
		}


		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}


		public String getPostalCode() {
			return postalCode;
		}


		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getRegion() {
			return region;
		}


		public void setRegion(String region) {
			this.region = region;
		}


		public String getLatitude() {
			return latitude;
		}


		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}


		public String getLongitude() {
			return longitude;
		}


		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}
		
		
	    
	    
	    

}
