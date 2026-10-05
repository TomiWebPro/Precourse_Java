public class book {
    private String title;
    private String Author;
    private int year;
    private boolean borrowed = false;

    //constructor
    public book(String title, String Author, int year){
        this.title = title;
        this.Author = Author;
        this.year = year;
    }

    //setter methods
    public void changeBookBorrowed(boolean inputBool){
        this.borrowed = inputBool;
    }

    //getter methods 
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.Author;
    }
    public int getYear(){
        return this.year;
    }
    public String getStringBorrowed(){
        if (this.borrowed){
            return "True";
        }else{
            return "False";
        }
    }
    public String getIfFoundByAuthor(String authorSearch){
        if (authorSearch.toLowerCase().equals(this.Author.toLowerCase())){
            return this.title;
        }else{
            return "";
        }
    }
    public String getIfFoundByName(String nameSearch){
        if (nameSearch.toLowerCase().equals(this.title.toLowerCase())){
            return this.title;
        }else{
            return "";
        }
    }
}
