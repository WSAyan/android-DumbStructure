# AndroidDumbStructure

This is a sample project using a simple project structure for typical android apps.

## Getting Started

First of all by the term 'Typical Android Apps' I meant an app which handles  http requests and SQLite database. In this sample project there is a list of Newspapers which comes from [News API](https://newsapi.org/) and there is a list of favourite newspapers which is saved on a SQLite db.  

### The Project Structure

The main goal here is to separate the ui classes like Activities or Fragments from business logics and crud operations. Lets jump into the structure. Mainly it contains four packages:
1. config
2. model
3. presenter
4. ui

### Package Details
- **config:** contains two sub packages
    1. api:
        Contains **ApiClient.java** class which creates Retrofit instance.
    2. db:
        Contains **DbHelper.java** class which extends the mighty **SQLiteOpenHelper** class. Now our goal is to separate this from ui           package classes completely and keep this class untouched from presenter. For that **DbConfig.java** is used to inject  **DbHelper.java** through instantiating that. DbCrud.java class contains four methods which executes four basic crud operations select,insert,update,delete and make a dataset which is in model package. 

- **model:** contains two sub packages
    1. binder:
        Most important package of the project. See this is why I call this a Dumb Structure because it does not contain any model class for db. Instead of model classes it contains ArrayList of HashMap extended in **DataTable.java** class. Each member of the list is a HashMap extended in **DataRow.java** class which maps columns with data for each and every rows of a table. Following code snippets will show you how you can use this classes to insert data in db.
        ```java
        @Override
        public int markFavourites(String id, String name, String description, String url) {
            DataTable dataTable = new DataTable(TABLE_FAVOURITES);
            DataRow dataRow = new DataRow();
            dataRow.add("id", id);
            dataRow.add("name", name);
            dataRow.add("description", description);
            dataRow.add("url", url);
            dataTable.add(0, dataRow);
            return dbCrud.insertData(dataTable, dbConfig.getSqLiteDatabase());
        }
        ```
        See the markFavourites method is implemented in **DbRepository.java** class which is called from an adapter class of **ui** package. Mark favourites inserts data via **DbCrud.java** classes insertData method into favourite table which contains id,name,description and url columns. **DbCrud.java** contains insert method like following snippet.
        ```java
        public int insertData(DataTable dataTable, SQLiteDatabase sqLiteDatabase) {
            long status = -500;
            String table = dataTable.getTableName();
            sqLiteDatabase.beginTransaction();
            for (DataRow dataRow : dataTable) {
                ContentValues contentValues = dataRow.getContentValues();
                status = sqLiteDatabase.insert(table, null, contentValues);
            }
            sqLiteDatabase.setTransactionSuccessful();
            sqLiteDatabase.endTransaction();
            sqLiteDatabase.close();
            return (int) status;
        }
        ```

    2. pojo:
        contains pojo classes for http responses.


- **presenter:** contains two interfaces and two classes. The **ApiInteface.java** is for handling all Retrofit the http requests and DbInterface.java is for all the business logic methods and crud operation handlers which is implemented in **DbRepository.java** class. InjectPresenter.java is the heart and soul of this package. It is used as a link between ui and model.

- **ui:** package contains all the adapters,fragments and activities classes. If you need to get data via http request from any classes of ui package you can call them like this:
   ```java
   Call<Sources> call = injectPresenter.getApiInterface().getNewsSources("en");
   ```
   And If you need to run any crud operation like updating or inserting data to db you can do it like this:
   ```java
   injectPresenter.getDbInterface(context).markFavourites(id, name, description, url);
   ```

## Running the tests


## Built With
* [Android Studio](https://developer.android.com/studio/index.html) – IDE 
* [Gradle](https://gradle.org/) - Dependency 
* [Maven](https://maven.apache.org/) - Dependency 

## Contributing


## Versioning

## Authors


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details



