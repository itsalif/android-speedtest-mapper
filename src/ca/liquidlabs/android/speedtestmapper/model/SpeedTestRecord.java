
package ca.liquidlabs.android.speedtestmapper.model;

import com.google.android.gms.maps.model.LatLng;

import org.apache.commons.csv.CSVRecord;

/**
 * POJO model which represents all the available attributes for SpeedTest(tm)
 * exported data.
 * 
 * @since SpeedTest v2.0.9
 */
public class SpeedTestRecord {

    //
    // Individual CSV keys for each header elements
    //
    private static final String KEY_DATE = "Date";
    private static final String KEY_CONNTYPE = "ConnType";
    private static final String KEY_LAT = "Lat";
    private static final String KEY_LON = "Lon";
    private static final String KEY_DOWNL = "Download";
    private static final String KEY_UPL = "Upload";
    private static final String KEY_LATENCY = "Latency";
    private static final String KEY_SERVER = "ServerName";
    private static final String KEY_IPINT = "InternalIp";
    private static final String KEY_IPEXT = "ExternalIp";

    //
    // Class Attributes
    //

    private String date;
    private String connectionType;
    private float lat;
    private float lon;
    private String download;
    private String upload;
    private int latency;
    private String serverName;
    private String internalIp;
    private String externalIp;

    /**
     * Constructs speedtest model object from parsed csv record.
     * 
     * @param csvRecord
     */
    public SpeedTestRecord(CSVRecord csvRecord) {
        this.date = csvRecord.get(KEY_DATE);
        this.connectionType = csvRecord.get(KEY_CONNTYPE);
        this.lat = Float.parseFloat(csvRecord.get(KEY_LAT));
        this.lon = Float.parseFloat(csvRecord.get(KEY_LON));
        this.download = csvRecord.get(KEY_DOWNL);
        this.upload = csvRecord.get(KEY_UPL);
        this.latency = Integer.parseInt(csvRecord.get(KEY_LATENCY));
        this.serverName = csvRecord.get(KEY_SERVER);
        this.internalIp = csvRecord.get(KEY_IPINT);
        this.externalIp = csvRecord.get(KEY_IPEXT);
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
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
    public String getConnectionType() {
        return connectionType;
    }

    /**
     * @param connectionType the connectionType to set
     */
    public void setConnectionType(String connectionType) {
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
     * 
     * @return {@link LatLng} object
     */
    public LatLng getLatLng(){
        return new LatLng(this.lat, this.lon);
    }

    /**
     * @return the download
     */
    public String getDownload() {
        return download;
    }

    /**
     * @param download the download to set
     */
    public void setDownload(String download) {
        this.download = download;
    }

    /**
     * @return the upload
     */
    public String getUpload() {
        return upload;
    }

    /**
     * @param upload the upload to set
     */
    public void setUpload(String upload) {
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
}