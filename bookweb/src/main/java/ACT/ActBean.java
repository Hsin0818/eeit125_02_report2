package ACT;

import java.io.Serializable;

public class ActBean implements Serializable {

	int MB_ID;
	int ACT_ID;
	String ACT_Name;
	String ACT_Theme;
	String ACT_Date;
	String ACT_Loc;
	String ACT_Intro;
	String ACT_Guest;
	String ACT_Pax;
	String ACT_Rule;
	String ACT_Tag;
	String ACT_Place;

	public ActBean(int MB_ID, int ACT_ID, String ACT_Name, String ACT_Theme, String ACT_Date, String ACT_Loc,
			String ACT_Intro, String ACT_Guest, String ACT_Pax, String ACT_Rule, String ACT_Tag, String ACT_Place) {
		this.MB_ID = MB_ID;
		this.ACT_ID = ACT_ID;
		this.ACT_Name = ACT_Name;
		this.ACT_Theme = ACT_Theme;
		this.ACT_Date = ACT_Date;
		this.ACT_Loc = ACT_Loc;
		this.ACT_Intro = ACT_Intro;
		this.ACT_Guest = ACT_Guest;
		this.ACT_Pax = ACT_Pax;
		this.ACT_Rule = ACT_Rule;
		this.ACT_Tag = ACT_Tag;
		this.ACT_Place = ACT_Place;
	}

	public ActBean() {

	}

	public int getMB_ID() {
		return MB_ID;
	}

	public void setMB_ID(int mB_ID) {
		MB_ID = mB_ID;
	}

	public int getACT_ID() {
		return ACT_ID;
	}

	public void setACT_ID(int aCT_ID) {
		ACT_ID = aCT_ID;
	}

	public String getACT_Name() {
		return ACT_Name;
	}

	public void setACT_Name(String aCT_Name) {
		ACT_Name = aCT_Name;
	}

	public String getACT_Theme() {
		return ACT_Theme;
	}

	public void setACT_Theme(String aCT_Theme) {
		ACT_Theme = aCT_Theme;
	}

	public String getACT_Date() {
		return ACT_Date;
	}

	public void setACT_Date(String aCT_Date) {
		ACT_Date = aCT_Date;
	}

	public String getACT_Loc() {
		return ACT_Loc;
	}

	public void setACT_Loc(String aCT_Loc) {
		ACT_Loc = aCT_Loc;
	}

	public String getACT_Intro() {
		return ACT_Intro;
	}

	public void setACT_Intro(String aCT_Intro) {
		ACT_Intro = aCT_Intro;
	}

	public String getACT_Guest() {
		return ACT_Guest;
	}

	public void setACT_Guest(String aCT_Guest) {
		ACT_Guest = aCT_Guest;
	}

	public String getACT_Pax() {
		return ACT_Pax;
	}

	public void setACT_Pax(String aCT_Pax) {
		ACT_Pax = aCT_Pax;
	}

	public String getACT_Rule() {
		return ACT_Rule;
	}

	public void setACT_Rule(String aCT_Rule) {
		ACT_Rule = aCT_Rule;
	}

	public String getACT_Tag() {
		return ACT_Tag;
	}

	public void setACT_Tag(String aCT_Tag) {
		ACT_Tag = aCT_Tag;
	}

	public String getACT_Place() {
		return ACT_Place;
	}

	public void setACT_Place(String aCT_Place) {
		ACT_Place = aCT_Place;
	}

}