// IMyAidlInterface.aidl
package share.serviceport_obj;
import android.os.Parcelable;
import android.os.Parcel;
import share.serviceport_obj.Person;//此处需要手写
// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    Person getPerson();
}
