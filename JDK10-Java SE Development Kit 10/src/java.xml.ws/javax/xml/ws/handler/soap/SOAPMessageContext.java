/*
 * Copyright (c) 2005, 2015, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package javax.xml.ws.handler.soap;

import javax.xml.soap.SOAPMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.namespace.QName;
import java.util.Set;

/** The interface {@code SOAPMessageContext}
 *  provides access to the SOAP message for either RPC request or
 *  response. The {@code javax.xml.soap.SOAPMessage} specifies
 *  the standard Java API for the representation of a SOAP 1.1 message
 *  with attachments.
 *
 *  @see javax.xml.soap.SOAPMessage
 *
 *  @since 1.6, JAX-WS 2.0
**/
public interface SOAPMessageContext
                    extends javax.xml.ws.handler.MessageContext {

  /** Gets the {@code SOAPMessage} from this message context. Modifications
   *  to the returned {@code SOAPMessage} change the message in-place, there
   *  is no need to subsequently call {@code setMessage}.
   *
   *  @return Returns the {@code SOAPMessage}; returns {@code null} if no
   *          {@code SOAPMessage} is present in this message context
  **/
  public SOAPMessage getMessage();

  /** Sets the SOAPMessage in this message context
   *
   *  @param  message SOAP message
   *  @throws javax.xml.ws.WebServiceException If any error during the setting
   *          of the {@code SOAPMessage} in this message context
   *  @throws java.lang.UnsupportedOperationException If this
   *          operation is not supported
  **/
  public void setMessage(SOAPMessage message);

  /** Gets headers that have a particular qualified name from the message in the
   *  message context. Note that a SOAP message can contain multiple headers
   *  with the same qualified name.
   *
   *  @param  header The XML qualified name of the SOAP header(s).
   *  @param  context The JAXBContext that should be used to unmarshall the
   *          header
   *  @param  allRoles If {@code true} then returns headers for all SOAP
   *          roles, if {@code false} then only returns headers targetted
   *          at the roles currently being played by this SOAP node, see
   *          {@code getRoles}.
   *  @return An array of unmarshalled headers; returns an empty array if no
   *          message is present in this message context or no headers match
   *          the supplied qualified name.
   *  @throws javax.xml.ws.WebServiceException If an error occurs when using the supplied
   *     {@code JAXBContext} to unmarshall. The cause of
   *     the {@code WebServiceException} is the original {@code JAXBException}.
  **/
  public Object[] getHeaders(QName header, JAXBContext context,
    boolean allRoles);

  /** Gets the SOAP actor roles associated with an execution
   *  of the handler chain.
   *  Note that SOAP actor roles apply to the SOAP node and
   *  are managed using {@link javax.xml.ws.soap.SOAPBinding#setRoles} and
   *  {@link javax.xml.ws.soap.SOAPBinding#getRoles}. {@code Handler} instances in
   *  the handler chain use this information about the SOAP actor
   *  roles to process the SOAP header blocks. Note that the
   *  SOAP actor roles are invariant during the processing of
   *  SOAP message through the handler chain.
   *
   *  @return Array of {@code String} for SOAP actor roles
  **/
  public Set<String> getRoles();
}
