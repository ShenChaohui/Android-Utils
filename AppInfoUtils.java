import java.util.ArrayList;
import java.util.List;
 
import android.content.pm.LauncherActivityInfo;
import android.content.pm.LauncherApps;
import android.os.UserHandle;
 
public class AppInfoUtils {
 
        private AppInfoUtils() {
                /* cannot be instantiated */
                throw new UnsupportedOperationException("cannot be instantiated");
 
        }
 
        /**
         * 获取应用程序名称
         * 
         * @param context
         * @return
         */
        public static String getAppName(Context context) {
                try {
                        PackageManager packageManager = context.getPackageManager();
                        PackageInfo packageInfo = packageManager.getPackageInfo(
                                        context.getPackageName(), 0);
                        int labelRes = packageInfo.applicationInfo.labelRes;
                        return context.getResources().getString(labelRes);
                } catch (NameNotFoundException e) {
                        e.printStackTrace();
                }
                return null;
        }
 
        /**
         * 获取应用程序版本名称信息
         * 
         * @param context
         * [url=home.php?mod=space&uid=309376]@return[/url] 当前应用的版本名称
         */
        public static String getVersionName(Context context) {
                try {
                        PackageManager packageManager = context.getPackageManager();
                        PackageInfo packageInfo = packageManager.getPackageInfo(
                                        context.getPackageName(), 0);
                        return packageInfo.versionName;
 
                } catch (NameNotFoundException e) {
                        e.printStackTrace();
                }
                return null;
        }
 
        /**
         * 获取application节点下的meta信息
         * 
         * @param context
         * @param params
         *            想要获取的参数
         * @return
         */
        public static String getMetaInfo(Context context, String params) {
 
                String packageName = context.getPackageName();
                // 获取application里面的meta信息
                try {
                        ApplicationInfo appInfo = context.getPackageManager()
                                        .getApplicationInfo(packageName,
                                                        PackageManager.GET_META_DATA);
                        return appInfo.metaData.getString(params);
                } catch (Exception e) {
                        System.out.println("获取渠道失败:" + e);
                        e.printStackTrace();
                }
                return null;
        }
 
        /**
         * 获取启动Activity的intent
         * 
         * @param context
         * @return
         */
        public static Intent getLaunchIntent(Context context) {
                String packageName = context.getPackageName();
                PackageManager pm = context.getPackageManager();
                Intent intent = pm.getLaunchIntentForPackage(packageName);
                return intent;
        }
         
        public static List<string> getLauncherAppPackageName(Context context){
             
            LauncherApps apps = (LauncherApps)context.getSystemService("launcherapps");
            UserHandle mUserHandle = android.os.Process.myUserHandle();
             
            List<launcheractivityinfo> activityInfos = apps.getActivityList(null, mUserHandle);
             
            List<string> launcherPackageNamesList = new ArrayList<string>();
             
            for (LauncherActivityInfo activityInfo : activityInfos) {
                String name = activityInfo.getApplicationInfo().packageName;
                launcherPackageNamesList.add(name);
            }
             
            return launcherPackageNamesList;
             
        }
}
