
package com.proyek.rahmanjai.eatit.Model;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2019-05-10T13:50+0530")
@SuppressWarnings({
    "unchecked",
    "deprecation"
})
public class Photo$$Parcelable
    implements Parcelable, ParcelWrapper<com.proyek.rahmanjai.eatit.Model.Photo>
{

    private com.proyek.rahmanjai.eatit.Model.Photo photo$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<Photo$$Parcelable>CREATOR = new Creator<Photo$$Parcelable>() {


        @Override
        public Photo$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new Photo$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public Photo$$Parcelable[] newArray(int size) {
            return new Photo$$Parcelable[size] ;
        }

    }
    ;

    public Photo$$Parcelable(com.proyek.rahmanjai.eatit.Model.Photo photo$$2) {
        photo$$0 = photo$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(photo$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.proyek.rahmanjai.eatit.Model.Photo photo$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(photo$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(photo$$1));
            parcel$$1 .writeString(photo$$1 .photoReference);
            parcel$$1 .writeInt(photo$$1 .width);
            parcel$$1 .writeInt(photo$$1 .height);
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.proyek.rahmanjai.eatit.Model.Photo getParcel() {
        return photo$$0;
    }

    public static com.proyek.rahmanjai.eatit.Model.Photo read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.proyek.rahmanjai.eatit.Model.Photo photo$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            photo$$4 = new com.proyek.rahmanjai.eatit.Model.Photo();
            identityMap$$1 .put(reservation$$0, photo$$4);
            photo$$4 .photoReference = parcel$$3 .readString();
            photo$$4 .width = parcel$$3 .readInt();
            photo$$4 .height = parcel$$3 .readInt();
            com.proyek.rahmanjai.eatit.Model.Photo photo$$3 = photo$$4;
            identityMap$$1 .put(identity$$1, photo$$3);
            return photo$$3;
        }
    }

}
