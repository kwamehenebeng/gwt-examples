package org.gonevertical.gadgetrpc.server.jdo;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;

public class TokenStore {

  public static String getToken(String id) {
    PersistenceManager pm = PMF.get().getPersistenceManager();

    try {
      Token token = pm.getObjectById(Token.class, id);

      return token.getToken();
    } catch (JDOObjectNotFoundException e) {
      return null;
    } finally {
      pm.close();
    }
  }

  public static void addToken(String id, String sessionToken) {
    PersistenceManager pm = PMF.get().getPersistenceManager();

    try {
      Token token = new Token(id, sessionToken);
      pm.makePersistent(token);
    } finally {
      pm.close();
    }
  }
  
}
