
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
public class ValuePair$$Parcelable
    implements Parcelable, ParcelWrapper<com.proyek.rahmanjai.eatit.Model.ValuePair>
{

    private com.proyek.rahmanjai.eatit.Model.ValuePair valuePair$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<ValuePair$$Parcelable>CREATOR = new Creator<ValuePair$$Parcelable>() {


        @Override
        public ValuePair$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new ValuePair$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public ValuePair$$Parcelable[] newArray(int size) {
            return new ValuePair$$Parcelable[size] ;
        }

    }
    ;

    public ValuePair$$Parcelable(com.proyek.rahmanjai.eatit.Model.ValuePair valuePair$$2) {
        valuePair$$0 = valuePair$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(valuePair$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.proyek.rahmanjai.eatit.Model.ValuePair valuePair$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(valuePair$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(valuePair$$1));
            parcel$$1 .writeString(valuePair$$1 .text);
            parcel$$1 .writeInt(valuePair$$1 .value);
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.proyek.rahmanjai.eatit.Model.ValuePair getParcel() {
        return valuePair$$0;
    }

    public static com.proyek.rahmanjai.eatit.Model.ValuePair read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.proyek.rahmanjai.eatit.Model.ValuePair valuePair$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            valuePair$$4 = new com.proyek.rahmanjai.eatit.Model.ValuePair();
            identityMap$$1 .put(reservation$$0, valuePair$$4);
            valuePair$$4 .text = parcel$$3 .readString();
            valuePair$$4 .value = parcel$$3 .readInt();
            com.proyek.rahmanjai.eatit.Model.ValuePair valuePair$$3 = valuePair$$4;
            identityMap$$1 .put(identity$$1, valuePair$$3);
            return valuePair$$3;
        }
    }

}
