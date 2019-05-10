
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
public class Geometry$$Parcelable
    implements Parcelable, ParcelWrapper<com.proyek.rahmanjai.eatit.Model.Geometry>
{

    private com.proyek.rahmanjai.eatit.Model.Geometry geometry$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<Geometry$$Parcelable>CREATOR = new Creator<Geometry$$Parcelable>() {


        @Override
        public Geometry$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new Geometry$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public Geometry$$Parcelable[] newArray(int size) {
            return new Geometry$$Parcelable[size] ;
        }

    }
    ;

    public Geometry$$Parcelable(com.proyek.rahmanjai.eatit.Model.Geometry geometry$$2) {
        geometry$$0 = geometry$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(geometry$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.proyek.rahmanjai.eatit.Model.Geometry geometry$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(geometry$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(geometry$$1));
            com.proyek.rahmanjai.eatit.Model.Location$$Parcelable.write(geometry$$1 .location, parcel$$1, flags$$0, identityMap$$0);
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.proyek.rahmanjai.eatit.Model.Geometry getParcel() {
        return geometry$$0;
    }

    public static com.proyek.rahmanjai.eatit.Model.Geometry read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.proyek.rahmanjai.eatit.Model.Geometry geometry$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            geometry$$4 = new com.proyek.rahmanjai.eatit.Model.Geometry();
            identityMap$$1 .put(reservation$$0, geometry$$4);
            Location location$$0 = com.proyek.rahmanjai.eatit.Model.Location$$Parcelable.read(parcel$$3, identityMap$$1);
            geometry$$4 .location = location$$0;
            com.proyek.rahmanjai.eatit.Model.Geometry geometry$$3 = geometry$$4;
            identityMap$$1 .put(identity$$1, geometry$$3);
            return geometry$$3;
        }
    }

}
