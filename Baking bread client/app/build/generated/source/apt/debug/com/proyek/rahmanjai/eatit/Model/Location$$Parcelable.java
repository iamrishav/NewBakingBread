
package com.proyek.rahmanjai.eatit.Model;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2019-05-10T06:24+0530")
@SuppressWarnings({
    "unchecked",
    "deprecation"
})
public class Location$$Parcelable
    implements Parcelable, ParcelWrapper<com.proyek.rahmanjai.eatit.Model.Location>
{

    private com.proyek.rahmanjai.eatit.Model.Location location$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<Location$$Parcelable>CREATOR = new Creator<Location$$Parcelable>() {


        @Override
        public Location$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new Location$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public Location$$Parcelable[] newArray(int size) {
            return new Location$$Parcelable[size] ;
        }

    }
    ;

    public Location$$Parcelable(com.proyek.rahmanjai.eatit.Model.Location location$$2) {
        location$$0 = location$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(location$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.proyek.rahmanjai.eatit.Model.Location location$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(location$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(location$$1));
            if (location$$1 .latitude == null) {
                parcel$$1 .writeInt(-1);
            } else {
                parcel$$1 .writeInt(1);
                parcel$$1 .writeDouble(location$$1 .latitude);
            }
            if (location$$1 .longitude == null) {
                parcel$$1 .writeInt(-1);
            } else {
                parcel$$1 .writeInt(1);
                parcel$$1 .writeDouble(location$$1 .longitude);
            }
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.proyek.rahmanjai.eatit.Model.Location getParcel() {
        return location$$0;
    }

    public static com.proyek.rahmanjai.eatit.Model.Location read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.proyek.rahmanjai.eatit.Model.Location location$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            location$$4 = new com.proyek.rahmanjai.eatit.Model.Location();
            identityMap$$1 .put(reservation$$0, location$$4);
            int int$$0 = parcel$$3 .readInt();
            java.lang.Double double$$0;
            if (int$$0 < 0) {
                double$$0 = null;
            } else {
                double$$0 = parcel$$3 .readDouble();
            }
            location$$4 .latitude = double$$0;
            int int$$1 = parcel$$3 .readInt();
            java.lang.Double double$$1;
            if (int$$1 < 0) {
                double$$1 = null;
            } else {
                double$$1 = parcel$$3 .readDouble();
            }
            location$$4 .longitude = double$$1;
            com.proyek.rahmanjai.eatit.Model.Location location$$3 = location$$4;
            identityMap$$1 .put(identity$$1, location$$3);
            return location$$3;
        }
    }

}
