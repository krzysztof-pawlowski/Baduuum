package pl.baduuum.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

import pl.baduuum.shared.Contact;
import pl.baduuum.shared.ContactDetails;

public interface ContactsServiceAsync {

  public void addContact(Contact contact, AsyncCallback<Contact> callback);
  public void deleteContact(String id, AsyncCallback<Boolean> callback);
  public void deleteContacts(ArrayList<String> ids, AsyncCallback<ArrayList<ContactDetails>> callback);
  public void getContactDetails(AsyncCallback<ArrayList<ContactDetails>> callback);
  public void getContact(String id, AsyncCallback<Contact> callback);
  public void updateContact(Contact contact, AsyncCallback<Contact> callback);
}

