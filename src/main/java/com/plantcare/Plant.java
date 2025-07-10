package com.plantcare;

public class Plant 
{
    public int id;
    public String name;
    public String category;
    public String sunlight;
    public String waterSchedule;
    public String soilType;

    public Plant(String name, String category, String sunlight, String waterSchedule, String soilType) 
    {
        this.name = name;
        this.category = category;
        this.sunlight = sunlight;
        this.waterSchedule = waterSchedule;
        this.soilType = soilType;
    }
}