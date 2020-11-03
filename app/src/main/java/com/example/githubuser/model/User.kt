package com.example.githubuser.model

import android.os.Parcel
import android.os.Parcelable

data class User(
    var name: String?,
    var dataUsername: String?,
    var dataFollower: String?,
    var dataFollowing: String?,
    var dataCompany: String?,
    var dataLocation: String?,
    var dataRepository: String?,
    var photo: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(dataUsername)
        parcel.writeString(dataFollower)
        parcel.writeString(dataFollowing)
        parcel.writeString(dataCompany)
        parcel.writeString(dataLocation)
        parcel.writeString(dataRepository)
        parcel.writeInt(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}