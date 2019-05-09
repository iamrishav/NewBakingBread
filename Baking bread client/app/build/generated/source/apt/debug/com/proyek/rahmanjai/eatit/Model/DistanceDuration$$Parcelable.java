
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
public class DistanceDuration$$Parcelable
    implements Parcelable, ParcelWrapper<com.proyek.rahmanjai.eatit.Model.DistanceDuration>
{

    private com.proyek.rahmanjai.eatit.Model.DistanceDuration distanceDuration$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<DistanceDuration$$Parcelable>CREATOR = new Creator<DistanceDuration$$Parcelable>() {


        @Override
        public DistanceDuration$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new DistanceDuration$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public DistanceDuration$$Parcelable[] newArray(int size) {
            return new DistanceDuration$$Parcelable[size] ;
        }

    }
    ;

    public DistanceDuration$$Parcelable(com.proyek.rahmanjai.eatit.Model.DistanceDuration distanceDuration$$2) {
        distanceDuration$$0 = distanceDuration$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(distanceDuration$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.proyek.rahmanjai.eatit.Model.DistanceDuration distanceDuration$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(distanceDuration$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(distanceDuration$$1));
            com.proyek.rahmanjai.eatit.Model.ValuePair$$Parcelable.write(distanceDuration$$1 .duration, parcel$$1, flags$$0, identityMap$$0);
            com.proyek.rahmanjai.eatit.Model.ValuePair$$Parcelable.write(distanceDuration$$1 .distance, parcel$$1, flags$$0, identityMap$$0);
            parcel$$1 .writeString(distanceDuration$$1 .status);
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.proyek.rahmanjai.eatit.Model.DistanceDuration getParcel() {
        return distanceDuration$$0;
    }

    public static com.proyek.rahmanjai.eatit.Model.DistanceDuration read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.proyek.rahmanjai.eatit.Model.DistanceDuration distanceDuration$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            distanceDuration$$4 = new com.proyek.rahmanjai.eatit.Model.DistanceDuration();
            identityMap$$1 .put(reservation$$0, distanceDuration$$4);
            com.proyek.rahmanjai.eatit.Model.ValuePair valuePair$$0 = com.proyek.rahmanjai.eatit.Model.ValuePair$$Parcelable.read(parcel$$3, identityMap$$1);
            distanceDuration$$4 .duration = valuePair$$0;
            com.proyek.rahmanjai.eatit.Model.ValuePair valuePair$$1 = com.proyek.rahmanjai.eatit.Model.ValuePair$$Parcelable.read(parcel$$3, identityMap$$1);
            distanceDuration$$4 .distance = valuePair$$1;
            distanceDuration$$4 .status = parcel$$3 .readString();
            com.proyek.rahmanjai.eatit.Model.DistanceDuration distanceDuration$$3 = distanceDuration$$4;
            identityMap$$1 .put(identity$$1, distanceDuration$$3);
            return distanceDuration$$3;
        }
    }

}
