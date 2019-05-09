
package com.proyek.rahmanjai.eatit.Model;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.LatLng;
import org.parceler.Generated;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2019-05-10T01:21+0530")
@SuppressWarnings({
    "unchecked",
    "deprecation"
})
public class SinglePlace$$Parcelable
    implements Parcelable, ParcelWrapper<com.proyek.rahmanjai.eatit.Model.SinglePlace>
{

    private com.proyek.rahmanjai.eatit.Model.SinglePlace singlePlace$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<SinglePlace$$Parcelable>CREATOR = new Creator<SinglePlace$$Parcelable>() {


        @Override
        public SinglePlace$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new SinglePlace$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public SinglePlace$$Parcelable[] newArray(int size) {
            return new SinglePlace$$Parcelable[size] ;
        }

    }
    ;

    public SinglePlace$$Parcelable(com.proyek.rahmanjai.eatit.Model.SinglePlace singlePlace$$2) {
        singlePlace$$0 = singlePlace$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(singlePlace$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.proyek.rahmanjai.eatit.Model.SinglePlace singlePlace$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(singlePlace$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(singlePlace$$1));
            parcel$$1 .writeParcelable(singlePlace$$1 .loc, flags$$0);
            parcel$$1 .writeInt(singlePlace$$1 .distance);
            parcel$$1 .writeString(singlePlace$$1 .icon);
            parcel$$1 .writeString(singlePlace$$1 .placeId);
            parcel$$1 .writeFloat(singlePlace$$1 .rating);
            parcel$$1 .writeString(singlePlace$$1 .distanceString);
            if (singlePlace$$1 .photos == null) {
                parcel$$1 .writeInt(-1);
            } else {
                parcel$$1 .writeInt(singlePlace$$1 .photos.size());
                for (com.proyek.rahmanjai.eatit.Model.Photo photo$$0 : ((java.util.ArrayList<com.proyek.rahmanjai.eatit.Model.Photo> ) singlePlace$$1 .photos)) {
                    com.proyek.rahmanjai.eatit.Model.Photo$$Parcelable.write(photo$$0, parcel$$1, flags$$0, identityMap$$0);
                }
            }
            parcel$$1 .writeString(singlePlace$$1 .timeString);
            parcel$$1 .writeString(singlePlace$$1 .name);
            parcel$$1 .writeString(singlePlace$$1 .vicinity);
            com.proyek.rahmanjai.eatit.Model.Geometry$$Parcelable.write(singlePlace$$1 .geometry, parcel$$1, flags$$0, identityMap$$0);
            parcel$$1 .writeString(singlePlace$$1 .id);
            parcel$$1 .writeInt(singlePlace$$1 .timeMinutes);
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.proyek.rahmanjai.eatit.Model.SinglePlace getParcel() {
        return singlePlace$$0;
    }

    public static com.proyek.rahmanjai.eatit.Model.SinglePlace read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.proyek.rahmanjai.eatit.Model.SinglePlace singlePlace$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            singlePlace$$4 = new com.proyek.rahmanjai.eatit.Model.SinglePlace();
            identityMap$$1 .put(reservation$$0, singlePlace$$4);
            singlePlace$$4 .loc = ((LatLng) parcel$$3 .readParcelable(SinglePlace$$Parcelable.class.getClassLoader()));
            singlePlace$$4 .distance = parcel$$3 .readInt();
            singlePlace$$4 .icon = parcel$$3 .readString();
            singlePlace$$4 .placeId = parcel$$3 .readString();
            singlePlace$$4 .rating = parcel$$3 .readFloat();
            singlePlace$$4 .distanceString = parcel$$3 .readString();
            int int$$0 = parcel$$3 .readInt();
            java.util.ArrayList<com.proyek.rahmanjai.eatit.Model.Photo> list$$0;
            if (int$$0 < 0) {
                list$$0 = null;
            } else {
                list$$0 = new java.util.ArrayList<com.proyek.rahmanjai.eatit.Model.Photo>(int$$0);
                for (int int$$1 = 0; (int$$1 <int$$0); int$$1 ++) {
                    com.proyek.rahmanjai.eatit.Model.Photo photo$$1 = com.proyek.rahmanjai.eatit.Model.Photo$$Parcelable.read(parcel$$3, identityMap$$1);
                    list$$0 .add(photo$$1);
                }
            }
            singlePlace$$4 .photos = list$$0;
            singlePlace$$4 .timeString = parcel$$3 .readString();
            singlePlace$$4 .name = parcel$$3 .readString();
            singlePlace$$4 .vicinity = parcel$$3 .readString();
            Geometry geometry$$0 = com.proyek.rahmanjai.eatit.Model.Geometry$$Parcelable.read(parcel$$3, identityMap$$1);
            singlePlace$$4 .geometry = geometry$$0;
            singlePlace$$4 .id = parcel$$3 .readString();
            singlePlace$$4 .timeMinutes = parcel$$3 .readInt();
            com.proyek.rahmanjai.eatit.Model.SinglePlace singlePlace$$3 = singlePlace$$4;
            identityMap$$1 .put(identity$$1, singlePlace$$3);
            return singlePlace$$3;
        }
    }

}
