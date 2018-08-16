package com.example.msrit.ratethefarm;

public class UserData {

    private int UserID;

    private String Name;
    private String Village;
    private String Hobli;
    private String Taluq;
    private int Age;

    private int MaleWorkers;
    private int FemaleWorkers;

    private double Land;
    private String IrrigatedOrRainfed;

    private int Cow;
    private int Buffalo;
    private int Cock;
    private int Hen;
    private int Sheep;
    private int Goat;
    private int OtherAnimals;

    private double MulberryYield;
    private Boolean SellMulberry;

    private Boolean OwnsTractor;
    private Boolean OwnsPowerTiller;
    private Boolean OwnsPlougher;
    private Boolean OwnsRotomator;
    private Boolean OwnsBullockCart;
    private Boolean OwnsSprayer;
    private Boolean OwnsSprinkler;

    private String CropName;
    private double CropArea;
    private double CropYield;

    private Boolean OnlineSale;
    private Boolean ScientificSuggestions;
    private Boolean OwnsNursery;

    private Boolean SalesLocal;
    private Boolean SalesAPMC;

    //To be calculated
    private int TotalAnimals;
    private double YieldPerHectre;
    private double Rating;

    public UserData() {
        Name = null;
        Village = null;
        Hobli = null;
        Taluq = null;
        Age = 0;
        MaleWorkers = 0;
        FemaleWorkers = 0;
        Land = 0.0;
        IrrigatedOrRainfed = null;
        Cow = 0;
        Buffalo = 0;
        Cock= 0;
        Hen = 0;
        Sheep = 0;
        Goat = 0;
        OtherAnimals = 0;
        MulberryYield = 0.0;
        SellMulberry = false;
        OwnsTractor = false;
        OwnsPowerTiller = false;
        OwnsPlougher = false;
        OwnsRotomator = false;
        OwnsBullockCart = false;
        OwnsSprayer = false;
        OwnsSprinkler = false;
        CropName = null;
        CropArea = 0.0;
        CropYield = 0.0;
        OnlineSale = false;
        ScientificSuggestions = false;
        OwnsNursery = false;
        SalesLocal = false;
        SalesAPMC = false;
        TotalAnimals = 0;
        YieldPerHectre = 0.0;
        Rating = 0.0;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getVillage() {
        return Village;
    }

    public void setVillage(String village) {
        Village = village;
    }

    public String getHobli() {
        return Hobli;
    }

    public void setHobli(String hobli) {
        Hobli = hobli;
    }

    public String getTaluq() {
        return Taluq;
    }

    public void setTaluq(String taluq) {
        Taluq = taluq;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getMaleWorkers() {
        return MaleWorkers;
    }

    public void setMaleWorkers(int maleWorkers) {
        MaleWorkers = maleWorkers;
    }

    public int getFemaleWorkers() {
        return FemaleWorkers;
    }

    public void setFemaleWorkers(int femaleWorkers) {
        FemaleWorkers = femaleWorkers;
    }

    public double getLand() {
        return Land;
    }

    public void setLand(double land) {
        Land = land;
    }

    public String getIrrigatedOrRainfed() {
        return IrrigatedOrRainfed;
    }

    public void setIrrigatedOrRainfed(String irrigatedOrRainfed) {
        IrrigatedOrRainfed = irrigatedOrRainfed;
    }

    public int getCow() {
        return Cow;
    }

    public void setCow(int cow) {
        Cow = cow;
    }

    public int getBuffalo() {
        return Buffalo;
    }

    public void setBuffalo(int buffalo) {
        Buffalo = buffalo;
    }

    public int getCock() {
        return Cock;
    }

    public void setCock(int cock) {
        Cock = cock;
    }

    public int getHen() {
        return Hen;
    }

    public void setHen(int hen) {
        Hen = hen;
    }

    public int getSheep() {
        return Sheep;
    }

    public void setSheep(int sheep) {
        Sheep = sheep;
    }

    public int getGoat() {
        return Goat;
    }

    public void setGoat(int goat) {
        Goat = goat;
    }

    public int getOtherAnimals() {
        return OtherAnimals;
    }

    public void setOtherAnimals(int otherAnimals) {
        OtherAnimals = otherAnimals;
    }

    public double getMulberryYield() {
        return MulberryYield;
    }

    public void setMulberryYield(double mulberryYield) {
        MulberryYield = mulberryYield;
    }

    public Boolean getSellMulberry() {
        return SellMulberry;
    }

    public void setSellMulberry(Boolean sellMulberry) {
        SellMulberry = sellMulberry;
    }

    public Boolean getOwnsTractor() {
        return OwnsTractor;
    }

    public void setOwnsTractor(Boolean ownsTractor) {
        OwnsTractor = ownsTractor;
    }

    public Boolean getOwnsPowerTiller() {
        return OwnsPowerTiller;
    }

    public void setOwnsPowerTiller(Boolean ownsPowerTiller) {
        OwnsPowerTiller = ownsPowerTiller;
    }

    public Boolean getOwnsPlougher() {
        return OwnsPlougher;
    }

    public void setOwnsPlougher(Boolean ownsPlougher) {
        OwnsPlougher = ownsPlougher;
    }

    public Boolean getOwnsRotomator() {
        return OwnsRotomator;
    }

    public void setOwnsRotomator(Boolean ownsRotomator) {
        OwnsRotomator = ownsRotomator;
    }

    public Boolean getOwnsBullockCart() {
        return OwnsBullockCart;
    }

    public void setOwnsBullockCart(Boolean ownsBullockCart) {
        OwnsBullockCart = ownsBullockCart;
    }

    public Boolean getOwnsSprayer() {
        return OwnsSprayer;
    }

    public void setOwnsSprayer(Boolean ownsSprayer) {
        OwnsSprayer = ownsSprayer;
    }

    public Boolean getOwnsSprinkler() {
        return OwnsSprinkler;
    }

    public void setOwnsSprinkler(Boolean ownsSprinkler) {
        OwnsSprinkler = ownsSprinkler;
    }

    public String getCropName() {
        return CropName;
    }

    public void setCropName(String cropName) {
        CropName = cropName;
    }

    public double getCropArea() {
        return CropArea;
    }

    public void setCropArea(double cropArea) {
        CropArea = cropArea;
    }

    public double getCropYield() {
        return CropYield;
    }

    public void setCropYield(double cropYield) {
        CropYield = cropYield;
    }

    public Boolean getOnlineSale() {
        return OnlineSale;
    }

    public void setOnlineSale(Boolean onlineSale) {
        OnlineSale = onlineSale;
    }

    public Boolean getScientificSuggestions() {
        return ScientificSuggestions;
    }

    public void setScientificSuggestions(Boolean scientificSuggestions) {
        ScientificSuggestions = scientificSuggestions;
    }

    public Boolean getOwnsNursery() {
        return OwnsNursery;
    }

    public void setOwnsNursery(Boolean ownsNursery) {
        OwnsNursery = ownsNursery;
    }

    public Boolean getSalesLocal() {
        return SalesLocal;
    }

    public void setSalesLocal(Boolean salesLocal) {
        SalesLocal = salesLocal;
    }

    public Boolean getSalesAPMC() {
        return SalesAPMC;
    }

    public void setSalesAPMC(Boolean salesAPMC) {
        SalesAPMC = salesAPMC;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }


    public int getTotalAnimals() {
        return TotalAnimals;
    }


    public double getYieldPerHectre() {
        return YieldPerHectre;
    }


    public double getRating() {
        return Rating;
    }

    public void setCalculatedValues() {
        // Rating =
        //Enter Rating algorithm here.

        TotalAnimals = Cock + Cow + Goat + Hen + Buffalo + Sheep + OtherAnimals;

        YieldPerHectre = CropYield / Land;

    }

}