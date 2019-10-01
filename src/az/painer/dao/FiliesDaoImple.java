package az.painer.dao;

import az.painer.db.FileDataManager;
import az.painer.model.Filies;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FiliesDaoImple implements FiliesInterface {




    Connection connection;
    PreparedStatement ps;
    ResultSet rs;

  /*  @Override
    public List<Filies> filiesList() throws Exception {
        List<Filies> filiesList=new ArrayList<>();
        String sql="SELECT ID,KEY,FILE_PATH FROM FILIES";
        try{
            connection=FileDataManager.getConnection();
            if(connection!=null){
                ps=connection.prepareStatement(sql);
                rs=ps.executeQuery();
                while (rs.next()){ //rs.next() yazilmalidir
                    Filies filies=new Filies();
                    filies.setId(rs.getInt("ID"));
                    filies.setKey(rs.getString("KEY"));
                    filies.setFilePath(rs.getString("FILE_PATH"));
                    filiesList.add(filies);
                }
            }else {
                System.out.println("Connection is null");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return filiesList;
    }*/

    @Override
    public boolean addFile(String key, String file_path) throws Exception {
        boolean result=false;
        String sql="insert into filies(id,key,file_path)\n" +
                "values(hospital.filies_seq.nextval,?,?)";
        try{
            connection= FileDataManager.getConnection();
            if(connection!=null){
                ps=connection.prepareStatement(sql);
                ps.setString(1,key);
                ps.setString(2,file_path);
                ps.execute();
                result=true;
            }
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public String findAllPath(String key) throws Exception {
        String x=null;
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select file_path from filies\n" +
                "where key=?";
        try{
           Connection c= FileDataManager.getConnection();
           if(c!=null){
               ps=c.prepareStatement(sql);
               ps.setString(1,key);
               rs=ps.executeQuery();
               while (rs.next()){
                Filies filies=new Filies();
               x =  filies.setFilePath(rs.getString("file_path"));

               }
           }
        }catch (Exception e){
            e.printStackTrace();
        }
        return x;
    }
}
