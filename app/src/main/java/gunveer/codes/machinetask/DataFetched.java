package gunveer.codes.machinetask;

import java.io.Serializable;

public class DataFetched implements Serializable {
    int id;
    String contact;
    String membership_number;
    String full_name, email_id, address, data_type, designation, list_year;
    String profile_pic_url;

    public DataFetched(int id, String contact, String membership_number, String list_year, String full_name, String email_id, String address, String data_type, String designation, String profile_pic_url) {
        this.id = id;
        this.contact = contact;
        this.membership_number = membership_number;
        this.list_year = list_year;
        this.full_name = full_name;
        this.email_id = email_id;
        this.address = address;
        this.data_type = data_type;
        this.designation = designation;
        this.profile_pic_url = profile_pic_url;
    }

    public DataFetched() {

    }

    @Override
    public String toString() {
        return
                "id = " + id + '\n' +
                "contact = " + contact + '\n' +
                "membership_number = " + membership_number + '\n' +
                "list_year = " + list_year + '\n' +
                "full_name = " + full_name + '\n' +
                "email_id = " + email_id + '\n' +
                "address = " + address + '\n' +
                "data_type = " + data_type + '\n' +
                "designation = " + designation + '\n' +
                "profile_pic_url = " + profile_pic_url + '\n';
    }
//    @NonNull
//    @Override
//    public String toString() {
//        return //"dataFetcheds {"+
//                "id="+ id + '\n'+
//                "full_name="+ full_name+'\n'+
//                "contact="+ contact +'\n'+
//                "email_id="+ email_id +'\n'+
//                "membership_number="+ membership_number+'\n'+
//                "address="+ address +'\n'+
//                "list_year="+ list_year+'\n'+
//                "data_type="+ data_type+'\n'+
//                "designation="+ designation+'\n'+
//                "profile_pic_url="+ profile_pic_url+'}';
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMembership_number() {
        return membership_number;
    }

    public void setMembership_number(String membership_number) {
        this.membership_number = membership_number;
    }

    public String getList_year() {
        return list_year;
    }

    public void setList_year(String list_year) {
        this.list_year = list_year;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getProfile_pic_url() {
        return profile_pic_url;
    }

    public void setProfile_pic_url(String profile_pic_url) {
        this.profile_pic_url = profile_pic_url;
    }
}
