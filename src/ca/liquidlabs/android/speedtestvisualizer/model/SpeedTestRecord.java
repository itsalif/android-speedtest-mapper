/*
 * Copyright 2013 Liquid Labs Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ca.liquidlabs.android.speedtestvisualizer.model;

import com.google.android.gms.maps.model.LatLng;

import org.apache.commons.csv.CSVRecord;

/**
 * POJO model which represents all the available attributes for SpeedTest(tm)
 * exported data.
 * 
 * @since SpeedTest v2.0.9
 */
public class SpeedTestRecord {
	
	
	/**
     * A String representation of the Class Name - which might be used to 
     * pass between activities 
     */
    public static final String KEY_NAME = SpeedTestRecord.class.getSimpleName();
	
    
    

    //
    // Individual CSV keys index for each header elements
    //
    private static final int KEY_DATE = 0;
    private static final int KEY_CONNTYPE = 1;
    private static final int KEY_LAT = 2;
    private static final int KEY_LON = 3;
    private static final int KEY_DOWNL = 4;
    private static final int KEY_UPL = 5;
    private static final int KEY_LATENCY = 6;
    private static final int KEY_SERVER = 7;
    private static final int KEY_IPINT = 8;
    private static final int KEY_IPEXT = 9;

    //
    // Class Attributes
    //

    private String date;
    private ConnectionType connectionType;
    private float lat;
    private float lon;
    private int download;
    private int upload;
    private int latency;
    private String serverName;
    private String internalIp;
    private String externalIp;
    
    
    
    
    //
    // Extra info added by this app
    //
    /**
     * Hue value store for each marker after calculation. Used by app internally.
     */
    private float markerColorHue;

    /**
     * Constructs speedtest model object from parsed csv record.
     * 
     * @param csvRecord
     */
    public SpeedTestRecord(CSVRecord csvRecord) {
        try {
            this.date = csvRecord.get(KEY_DATE);

            // data connection type - should be one of expected values
            this.connectionType = ConnectionType.fromString(csvRecord.get(KEY_CONNTYPE));

            // Lat, Lon is in float
            this.lat = Float.parseFloat(csvRecord.get(KEY_LAT));
            this.lon = Float.parseFloat(csvRecord.get(KEY_LON));

            // download and upload values are always in kbps
            this.download = Integer.parseInt(csvRecord.get(KEY_DOWNL));
            this.upload = Integer.parseInt(csvRecord.get(KEY_UPL));

            // latency is numeric - in milliseconds
            this.latency = Integer.parseInt(csvRecord.get(KEY_LATENCY));

            this.serverName = csvRecord.get(KEY_SERVER);
            this.internalIp = csvRecord.get(KEY_IPINT);
            this.externalIp = csvRecord.get(KEY_IPEXT);
        } catch (NumberFormatException e) {
            // if for some reason unexpected value is passed, stop parsing
            throw new IllegalArgumentException("Unable to parse record: " + csvRecord.toString());
        }
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return SpeedTestRecord.class.getSimpleName() + " [date=" + date + ", connectionType="
                + connectionType
                + ", download=" + download + ", upload=" + upload + "]";
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the connectionType
     */
    public ConnectionType getConnectionType() {
        return connectionType;
    }

    /**
     * @param connectionType the connectionType to set
     */
    public void setConnectionType(ConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    /**
     * @return the lat
     */
    public float getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(float lat) {
        this.lat = lat;
    }

    /**
     * @return the lon
     */
    public float getLon() {
        return lon;
    }

    /**
     * @param lon the lon to set
     */
    public void setLon(float lon) {
        this.lon = lon;
    }

    /**
     * @return {@link LatLng} object
     */
    public LatLng getLatLng() {
        return new LatLng(this.lat, this.lon);
    }

    /**
     * @return the download
     */
    public int getDownload() {
        return download;
    }

    /**
     * @param download the download to set
     */
    public void setDownload(int download) {
        this.download = download;
    }

    /**
     * @return the upload
     */
    public int getUpload() {
        return upload;
    }

    /**
     * @param upload the upload to set
     */
    public void setUpload(int upload) {
        this.upload = upload;
    }

    /**
     * @return the latency
     */
    public int getLatency() {
        return latency;
    }

    /**
     * @param latency the latency to set
     */
    public void setLatency(int latency) {
        this.latency = latency;
    }

    /**
     * @return the serverName
     */
    public String getServerName() {
        return serverName;
    }

    /**
     * @param serverName the serverName to set
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    /**
     * @return the internalIp
     */
    public String getInternalIp() {
        return internalIp;
    }

    /**
     * @param internalIp the internalIp to set
     */
    public void setInternalIp(String internalIp) {
        this.internalIp = internalIp;
    }

    /**
     * @return the externalIp
     */
    public String getExternalIp() {
        return externalIp;
    }

    /**
     * @param externalIp the externalIp to set
     */
    public void setExternalIp(String externalIp) {
        this.externalIp = externalIp;
    }

    
    //
    // Getter/Setter methods for Extra Infos
    //
    
    public float getMarkerColorHue() {
        return markerColorHue;
    }

    public void setMarkerColorHue(float markerColorHue) {
        this.markerColorHue = markerColorHue;
    }
    
    
    /**
     * Compares Two SpeedTestRecord and returns true if they 
     * have the same lat, lon and date. Otherwise returns false
     */
    @Override
    public boolean equals(Object other) 
    {
    	if (other == null || !(other instanceof SpeedTestRecord)) {
    		return false;
    	}
    	
    	SpeedTestRecord speedOther = (SpeedTestRecord) other;
    	
    	return (speedOther.lat == this.lat && speedOther.lon == this.lon 
    			&& speedOther.date.equals(this.date)); 
    	
    	
    }
        
    
}
