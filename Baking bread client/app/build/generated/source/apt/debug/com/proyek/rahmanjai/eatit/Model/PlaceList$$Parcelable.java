
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
public class PlaceList$$Parcelable
    implements Parcelable, ParcelWrapper<com.proyek.rahmanjai.eatit.Model.PlaceList>
{

    private com.proyek.rahmanjai.eatit.Model.PlaceList placeList$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<PlaceList$$Parcelable>CREATOR = new Creator<PlaceList$$Parcelable>() {


        @Override
        public PlaceList$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new PlaceList$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public PlaceList$$Parcelable[] newArray(int size) {
            return new PlaceList$$Parcelable[size] ;
        }

    }
    ;

    public PlaceList$$Parcelable(com.proyek.rahmanjai.eatit.Model.PlaceList placeList$$2) {
        placeList$$0 = placeList$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(placeList$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.proyek.rahmanjai.eatit.Model.PlaceList placeList$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(placeList$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(placeList$$1));
            if (placeList$$1 .places == null) {
                parcel$$1 .writeInt(-1);
            } else {
                parcel$$1 .writeInt(placeList$$1 .places.size());
                for (com.proyek.rahmanjai.eatit.Model.SinglePlace singlePlace$$0 : ((java.util.ArrayList<com.proyek.rahmanjai.eatit.Model.SinglePlace> ) placeList$$1 .places)) {
                    com.proyek.rahmanjai.eatit.Model.SinglePlace$$Parcelable.write(singlePlace$$0, parcel$$1, flags$$0, identityMap$$0);
                }
            }
            parcel$$1 .writeString(placeList$$1 .nextPageToken);
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.proyek.rahmanjai.eatit.Model.PlaceList getParcel() {
        return placeList$$0;
    }

    public static com.proyek.rahmanjai.eatit.Model.PlaceList read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.proyek.rahmanjai.eatit.Model.PlaceList placeList$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            placeList$$4 = new com.proyek.rahmanjai.eatit.Model.PlaceList();
            identityMap$$1 .put(reservation$$0, placeList$$4);
            int int$$0 = parcel$$3 .readInt();
            java.util.ArrayList<com.proyek.rahmanjai.eatit.Model.SinglePlace> list$$0;
            if (int$$0 < 0) {
                list$$0 = null;
            } else {
                list$$0 = new java.util.ArrayList<com.proyek.rahmanjai.eatit.Model.SinglePlace>(int$$0);
                for (int int$$1 = 0; (int$$1 <int$$0); int$$1 ++) {
                    com.proyek.rahmanjai.eatit.Model.SinglePlace singlePlace$$1 = com.proyek.rahmanjai.eatit.Model.SinglePlace$$Parcelable.read(parcel$$3, identityMap$$1);
                    list$$0 .add(singlePlace$$1);
                }
            }
            placeList$$4 .places = list$$0;
            placeList$$4 .nextPageToken = parcel$$3 .readString();
            com.proyek.rahmanjai.eatit.Model.PlaceList placeList$$3 = placeList$$4;
            identityMap$$1 .put(identity$$1, placeList$$3);
            return placeList$$3;
        }
    }

}
