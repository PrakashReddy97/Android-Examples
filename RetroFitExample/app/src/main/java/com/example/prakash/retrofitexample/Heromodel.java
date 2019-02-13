package com.example.prakash.retrofitexample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

@Entity(tableName = "users")
public class Heromodel implements Parcelable {
	private String createdby;
	private String firstappearance;
	private String imageurl;
	@PrimaryKey
	@NonNull private String name;
	private String publisher;
	private String bio;
	private String team;
	private String realname;

	public Heromodel() {
	}

	protected Heromodel(Parcel in) {
		createdby = in.readString();
		firstappearance = in.readString();
		imageurl = in.readString();
		name = in.readString();
		publisher = in.readString();
		bio = in.readString();
		team = in.readString();
		realname = in.readString();
	}

	public static final Creator<Heromodel> CREATOR = new Creator<Heromodel>() {
		@Override
		public Heromodel createFromParcel(Parcel in) {
			return new Heromodel(in);
		}

		@Override
		public Heromodel[] newArray(int size) {
			return new Heromodel[size];
		}
	};

	public void setCreatedby(String createdby){
		this.createdby = createdby;
	}

	public String getCreatedby(){
		return createdby;
	}

	public void setFirstappearance(String firstappearance){
		this.firstappearance = firstappearance;
	}

	public String getFirstappearance(){
		return firstappearance;
	}

	public void setImageurl(String imageurl){
		this.imageurl = imageurl;
	}

	public String getImageurl(){
		return imageurl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPublisher(String publisher){
		this.publisher = publisher;
	}

	public String getPublisher(){
		return publisher;
	}

	public void setBio(String bio){
		this.bio = bio;
	}

	public String getBio(){
		return bio;
	}

	public void setTeam(String team){
		this.team = team;
	}

	public String getTeam(){
		return team;
	}

	public void setRealname(String realname){
		this.realname = realname;
	}

	public String getRealname(){
		return realname;
	}

	@Override
 	public String toString(){
		return 
			"Heromodel{" + 
			"createdby = '" + createdby + '\'' + 
			",firstappearance = '" + firstappearance + '\'' + 
			",imageurl = '" + imageurl + '\'' + 
			",name = '" + name + '\'' + 
			",publisher = '" + publisher + '\'' + 
			",bio = '" + bio + '\'' + 
			",team = '" + team + '\'' + 
			",realname = '" + realname + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(createdby);
		dest.writeString(firstappearance);
		dest.writeString(imageurl);
		dest.writeString(name);
		dest.writeString(publisher);
		dest.writeString(bio);
		dest.writeString(team);
		dest.writeString(realname);
	}
}
