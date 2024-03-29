import java.lang.invoke.StringConcatFactory;
import java.sql.*;
import java.util.ArrayList;

public class Operation {
    static Connection con;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reserv", "root", "sql123");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    void Login (String username, String password){
            Statement stmt;
            ResultSet rs;

            String query = "Select user_name , password from login_info where user_name='"+username+"'and password='"+password+"'";

            try {
                stmt= con.createStatement();
                rs= stmt.executeQuery(query);
                boolean status=false;
                if(rs.next()){
                    status= true;
                    System.out.println("login Successful");
                    //task1 t1=new task1();
                }else{
                    System.out.println("login fail");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public int addRecord(passengerRecord pr) throws SQLException {
             PreparedStatement pstmt=null;
             int count=0;
             String insertQuery = "insert into journey (passenger_Name, train_No, class_type, journey_date, journey_From, journey_To) values( ?, ?, ?, ?, ?, ?)";
             try {
                 pstmt = con.prepareStatement(insertQuery);
                 pstmt.setString(1, pr.getPassengerName());
                 pstmt.setString(2, pr.getTrainNumber());
                 pstmt.setString(3, pr.getClassType());
                 pstmt.setString(4, pr.getJourneyDate());
                 pstmt.setString(5, pr.getFrom());
                 pstmt.setString(6, pr.getTo());
                 count = pstmt.executeUpdate();
             }catch(SQLException e) {
                 throw new RuntimeException(e);
             }
             return count;
        }

        public int removeRecord(passengerRecord pr){
            PreparedStatement pstmt;
            int count =0;
            String deleteQuery = "delete from journey where pnr_No = ?";
            try {
                pstmt = con.prepareStatement(deleteQuery);
                pstmt.setInt(1,pr.getPrnNumber());
                count= pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
            return count;
        }

        public ArrayList<passengerRecord> showRecord(){
        //display record
        Statement stmt;
        ResultSet rs;
        ArrayList<passengerRecord> recordlist =new ArrayList<>();
        //create sql query
        String query = "select * from journey";
            try {
                stmt = con.createStatement();
                rs= stmt.executeQuery(query);
                while (rs.next()){
                    //fetch data from columns
                    int pnr = rs.getInt(1);
                    String pname = rs.getString(2);
                    String trainno = rs.getString(3);
                    String classType = rs.getString(4);
                    String jdate = rs.getString(5);
                    String jfrom = rs.getString(6);
                    String jto = rs.getString(7);

                    //add info into passengerRecord class object
                    passengerRecord pr1= new passengerRecord();
                    pr1.setPrnNumber(pnr);
                    pr1.setPassengerName(pname);
                    pr1.setTrainNumber(trainno);
                    pr1.setClassType(classType);
                    pr1.setJourneyDate(jdate);
                    pr1.setFrom(jfrom);
                    pr1.setTo(jfrom);

                    //add passengerRecord class object into list
                    recordlist.add(pr1);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return recordlist;
        }
}
