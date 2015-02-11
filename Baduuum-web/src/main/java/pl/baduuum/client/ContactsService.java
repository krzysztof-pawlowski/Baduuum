package pl.baduuum.client;

import com.google.gwt.user.client.rpc.RemoteService; 
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.ArrayList;

import pl.baduuum.shared.Contact;
import pl.baduuum.shared.ContactDetails;

@RemoteServiceRelativePath("contactsService")
public interface ContactsService extends RemoteService {
	
  Contact addContact(Contact contact);
  Boolean deleteContact(String id); 
  ArrayList<ContactDetails> deleteContacts(ArrayList<String> ids);
  ArrayList<ContactDetails> getContactDetails();
  Contact getContact(String id);
  Contact updateContact(Contact contact);
}
