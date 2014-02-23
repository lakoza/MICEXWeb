package com.anneke;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;

public class PageFactory {

    public Document readHTML(){
        File input = new File("g:\\testServlets\\WEB-INF\\tableTemplate.html");
        Document doc = null;
        try {
            doc = Jsoup.parse(input, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return doc;
    }

    public Document addTag(Document document, String addAfterTag, String tagToBeAdded){
        Element table = document.select(addAfterTag).first();
        table.append(tagToBeAdded);

        return document;
    }

    public String getPage(){

        DatabaseService dbData = new DatabaseService();
        StringBuffer data = dbData.getResulSetData();

        System.out.println(data.toString());

        PageFactory page = new PageFactory();
        Document document = page.readHTML();
        page.addTag(document, "table", data.toString());

        //System.out.println();

        return document.toString();
    }

    public static void main(String[] args) throws ClassNotFoundException
    {
        DatabaseService dbData = new DatabaseService();
        StringBuffer data = dbData.getResulSetData();

        System.out.println(data.toString());

        PageFactory page = new PageFactory();
        Document document = page.readHTML();
        page.addTag(document, "table", data.toString());

        //System.out.println(document.toString());

        BufferedWriter htmlWriter = null;
        try {

            PrintWriter pw = new PrintWriter(new FileWriter("g:\\testServlets\\WEB-INF\\tableReady2.html"));
            pw.print(document.toString());

            //htmlWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("g:\\testServlets\\WEB-INF\\tableReady.html"), "UTF-8"));
            //htmlWriter.write(document.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        //System.out.println(document);
    }

}
