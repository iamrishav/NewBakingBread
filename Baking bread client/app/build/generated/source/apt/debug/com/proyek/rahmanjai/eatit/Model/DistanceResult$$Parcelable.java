
package com.proyek.rahmanjai.eatit.Model;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2019-05-10T01:21+0530")
@SuppressWarnings({
    "unchecked",
    "deprecation"
})
public class DistanceResult$$Parcelable
    implements Parcelable, ParcelWrapper<com.proyek.rahmanjai.eatit.Model.DistanceResult>
{

    private com.proyek.rahmanjai.eatit.Model.DistanceResult distanceResult$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<DistanceResult$$Parcelable>CREATOR = new Creator<DistanceResult$$Parcelable>() {


        @Override
        public DistanceResult$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new DistanceResult$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public DistanceResult$$Parcelable[] newArray(int size) {
            return new DistanceResult$$Parcelable[size] ;
        }

    }
    ;

    public DistanceResult$$Parcelable(com.proyek.rahmanjai.eatit.Model.DistanceResult distanceResult$$2) {
        distanceResult$$0 = distanceResult$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(distanceResult$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.proyek.rahmanjai.eatit.Model.DistanceResult distanceResult$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(distanceResult$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(distanceResult$$1));
            if (distanceResult$$1 .originAddresses == null) {
                parcel$$1 .writeInt(-1);
            } else {
                parcel$$1 .writeInt(distanceResult$$1 .originAddresses.size());
                for (java.lang.String string$$0 : ((java.util.ArrayList<java.lang.String> ) distanceResult$$1 .originAddresses)) {
                    parcel$$1 .writeString(string$$0);
                }
            }
            if (distanceResult$$1 .destinationAddresses == null) {
                parcel$$1 .writeInt(-1);
            } else {
                parcel$$1 .writeInt(distanceResult$$1 .destinationAddresses.size());
                for (java.lang.String string$$1 : ((java.util.ArrayList<java.lang.String> ) distanceResult$$1 .destinationAddresses)) {
                    parcel$$1 .writeString(string$$1);
                }
            }
            if (distanceResult$$1 .rows == null) {
                parcel$$1 .writeInt(-1);
            } else {
                parcel$$1 .writeInt(distanceResult$$1 .rows.size());
                for (com.proyek.rahmanjai.eatit.Model.ElementsArray elementsArray$$0 : ((java.util.ArrayList<com.proyek.rahmanjai.eatit.Model.ElementsArray> ) distanceResult$$1 .rows)) {
                    com.proyek.rahmanjai.eatit.Model.ElementsArray$$Parcelable.write(elementsArray$$0, parcel$$1, flags$$0, identityMap$$0);
                }
            }
            parcel$$1 .writeString(distanceResult$$1 .status);
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.proyek.rahmanjai.eatit.Model.DistanceResult getParcel() {
        return distanceResult$$0;
    }

    public static com.proyek.rahmanjai.eatit.Model.DistanceResult read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.proyek.rahmanjai.eatit.Model.DistanceResult distanceResult$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            distanceResult$$4 = new com.proyek.rahmanjai.eatit.Model.DistanceResult();
            identityMap$$1 .put(reservation$$0, distanceResult$$4);
            int int$$0 = parcel$$3 .readInt();
            java.util.ArrayList<java.lang.String> list$$0;
            if (int$$0 < 0) {
                list$$0 = null;
            } else {
                list$$0 = new java.util.ArrayList<java.lang.String>(int$$0);
                for (int int$$1 = 0; (int$$1 <int$$0); int$$1 ++) {
                    list$$0 .add(parcel$$3 .readString());
                }
            }
            distanceResult$$4 .originAddresses = list$$0;
            int int$$2 = parcel$$3 .readInt();
            java.util.ArrayList<java.lang.String> list$$1;
            if (int$$2 < 0) {
                list$$1 = null;
            } else {
                list$$1 = new java.util.ArrayList<java.lang.String>(int$$2);
                for (int int$$3 = 0; (int$$3 <int$$2); int$$3 ++) {
                    list$$1 .add(parcel$$3 .readString());
                }
            }
            distanceResult$$4 .destinationAddresses = list$$1;
            int int$$4 = parcel$$3 .readInt();
            java.util.ArrayList<com.proyek.rahmanjai.eatit.Model.ElementsArray> list$$2;
            if (int$$4 < 0) {
                list$$2 = null;
            } else {
                list$$2 = new java.util.ArrayList<com.proyek.rahmanjai.eatit.Model.ElementsArray>(int$$4);
                for (int int$$5 = 0; (int$$5 <int$$4); int$$5 ++) {
                    com.proyek.rahmanjai.eatit.Model.ElementsArray elementsArray$$1 = com.proyek.rahmanjai.eatit.Model.ElementsArray$$Parcelable.read(parcel$$3, identityMap$$1);
                    list$$2 .add(elementsArray$$1);
                }
            }
            distanceResult$$4 .rows = list$$2;
            distanceResult$$4 .status = parcel$$3 .readString();
            com.proyek.rahmanjai.eatit.Model.DistanceResult distanceResult$$3 = distanceResult$$4;
            identityMap$$1 .put(identity$$1, distanceResult$$3);
            return distanceResult$$3;
        }
    }

}
