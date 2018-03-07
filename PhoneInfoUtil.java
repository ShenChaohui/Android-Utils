public class PhoneInfoUtils {
 
        private Context context;
        private String deviceId;
        private String imei;
        private String imsi;
        private String manufacture;
        private String model;
        private int screenWidth;
        private int screenHeight;
        private String version_release;
        private String phoneNumber;
 
        public PhoneInfoUtils(Context context) {
                this.context = context;
        }
         
 
        public void getPhoneInfo() {
                TelephonyManager tm = (TelephonyManager) context
                                .getSystemService(Context.TELEPHONY_SERVICE);
 
                deviceId = Settings.Secure.getString(context.getContentResolver(),
                                Settings.Secure.ANDROID_ID);
                imsi = tm.getSubscriberId();
                imei = tm.getDeviceId();
 
                // 手机制造商
                manufacture = Build.MANUFACTURER;
 
                model = Build.MODEL; // 手机型号
 
                DisplayMetrics dm = context.getResources().getDisplayMetrics();
                screenWidth = dm.widthPixels;
                screenHeight = dm.heightPixels;
 
                version_release = Build.VERSION.RELEASE; // 系统版本号
 
                phoneNumber = tm.getLine1Number(); // 获取手机号码
        }
 
        @Override
        public String toString() {
                return "PhoneInfoUtils [deviceId=" + deviceId + ", imei=" + imei
                                + ", imsi=" + imsi + ", manufacture=" + manufacture
                                + ", model=" + model + ", screenWidth=" + screenWidth
                                + ", screenHeight=" + screenHeight + ", version_release="
                                + version_release + ", phoneNumber=" + phoneNumber + "]";
        }
 
}
