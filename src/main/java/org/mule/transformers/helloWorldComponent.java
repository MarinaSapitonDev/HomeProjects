package org.mule.transformers;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class helloWorldComponent implements Callable{
@Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
	 Object result=null;
	 try {

         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = factory.newDocumentBuilder();
         InputSource is = new InputSource(new StringReader(eventContext.getMessageAsString()));
         Document document = builder.parse(is);
         
         DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder2 = factory2.newDocumentBuilder();
         Document doc2 = builder2.newDocument();
         
         result= addNodes(document,doc2,eventContext.getMessage().getUniqueId());
       
      

     } catch (ParserConfigurationException ex) {
         ex.printStackTrace(System.out);
     } catch (SAXException ex) {
         ex.printStackTrace(System.out);
     } catch (IOException ex) {
         ex.printStackTrace(System.out);
     }
	
	  return  result;
	
    }

private Object addNodes(Document document, Document doc2, String stringMessageID) throws TransformerFactoryConfigurationError, DOMException {
    
	Date currentDate = new Date();
    String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(currentDate);
    
    Element rootElement = doc2.createElement("Message");
    doc2.appendChild(rootElement);
    /*head*****************************/
    Element head=doc2.createElement("head");
    Element date=doc2.createElement("date");
    Element messageID=doc2.createElement("messageID");
    Element messageType=doc2.createElement("messageType");
    Element autoshiporderheaderId=doc2.createElement("autoshiporderheaderId");
    Element destinationprovidercode=doc2.createElement("destinationprovidercode");
    Element interceptorname=doc2.createElement("interceptorname");
    Element responsedestinationprovidercode=doc2.createElement("responsedestinationprovidercode");
    
         /***sender**********/
    Element sender=doc2.createElement("sender");
    Element systemID=doc2.createElement("systemID");
    Element companyID=doc2.createElement("companyID");
    Element replyToQ=doc2.createElement("replyToQ");
                /*****recipient**********/
    Element recipient=doc2.createElement("recipient");
    Element systemID1=doc2.createElement("systemID");
    Element companyID1=doc2.createElement("companyID");
    Element replyToQ1=doc2.createElement("replyToQ");
    
    /***body****/
    Element body=doc2.createElement("body");
    Element orderImport=doc2.createElement("orderImport");
    Element orderHeader=doc2.createElement("orderHeader");
       /*****orderHeader********/
    Element merchantCode=doc2.createElement("merchantCode");
    Element projectCode=doc2.createElement("projectCode");
    Element ordertypeCode=doc2.createElement("ordertypeCode");
    Element localeCode=doc2.createElement("localeCode");
    Element orderedByUserName=doc2.createElement("orderedByUserName");
    Element custodianUserName=doc2.createElement("custodianUserName");
    Element clientreference=doc2.createElement("clientreference");
    Element referencefield1=doc2.createElement("referencefield1");
    Element referencefield2=doc2.createElement("referencefield2");
    Element referencefield3=doc2.createElement("referencefield3");
    Element referencefield4=doc2.createElement("referencefield4");
    Element referencefield5=doc2.createElement("referencefield5");
    Element distributionJobNumber=doc2.createElement("distributionJobNumber");
    Element comments=doc2.createElement("comments");
    Element ordernotes=doc2.createElement("ordernotes");
    Element shipcomplete=doc2.createElement("shipcomplete");
    Element orderStatusCode=doc2.createElement("orderStatusCode");
    Element providerCode=doc2.createElement("providerCode");
    Element priorityCode=doc2.createElement("priorityCode");
    Element workOrderTypeCode=doc2.createElement("workOrderTypeCode");
    Element affiliateCode=doc2.createElement("affiliateCode");
    Element marketingSourceCode=doc2.createElement("marketingSourceCode");
    Element releaseDate=doc2.createElement("releaseDate");
    Element orderSourceCode=doc2.createElement("orderSourceCode");
    Element workOrderReference=doc2.createElement("workOrderReference");
    Element completeByDate=doc2.createElement("completeByDate");
    Element promotionCode=doc2.createElement("promotionCode");
    Element salesTerritoryCode=doc2.createElement("salesTerritoryCode");
    Element billingCode=doc2.createElement("billingCode");
    Element budgetCenterCode=doc2.createElement("budgetCenterCode");
    Element exceptionType=doc2.createElement("exceptionType");
    Element exceptionMessage=doc2.createElement("exceptionMessage");
    Element createDateTime=doc2.createElement("createDateTime");
    Element createDateTimeZone=doc2.createElement("createDateTimeZone");
    Element reduceInventory=doc2.createElement("reduceInventory");
    
    
    date.setTextContent(modifiedDate);
    messageID.setTextContent(stringMessageID);
    messageType.setTextContent("orderImport");
    destinationprovidercode.setTextContent("TESTOrderImport");
    systemID.setTextContent("TEST");
    companyID.setTextContent("TEST");
    merchantCode.setTextContent("TEST");
    projectCode.setTextContent("TEST");
    ordertypeCode.setTextContent("Sales");
    localeCode.setTextContent("en-US");
    clientreference.setTextContent("123456789");
    shipcomplete.setTextContent("1");
    orderStatusCode.setTextContent("New");
    providerCode.setTextContent("B2");
    orderSourceCode.setTextContent("Internet");
    billingCode.setTextContent("Consumer");
    
    
   rootElement.appendChild(head);  
   rootElement.appendChild(body); 
   
   head.appendChild(messageID);
   head.appendChild(date);
   head.appendChild(messageType);
   head.appendChild(autoshiporderheaderId);
   head.appendChild(destinationprovidercode);
   head.appendChild(interceptorname);
   head.appendChild(responsedestinationprovidercode); 
   head.appendChild(sender);
     sender.appendChild(systemID);
     sender.appendChild(companyID);
     sender.appendChild(replyToQ);
  head.appendChild(recipient); 
     recipient.appendChild(systemID1);
     recipient.appendChild(companyID1);
     recipient.appendChild(replyToQ1);
     
   body.appendChild(orderImport);
      orderImport.appendChild(orderHeader);
          orderHeader.appendChild(merchantCode);
          orderHeader.appendChild(projectCode);
          orderHeader.appendChild(ordertypeCode); 
          orderHeader.appendChild(localeCode);
          orderHeader.appendChild(orderedByUserName);
          orderHeader.appendChild(custodianUserName);
          orderHeader.appendChild(clientreference);
          orderHeader.appendChild(referencefield1);
          orderHeader.appendChild(referencefield2);
          orderHeader.appendChild(referencefield3);
          orderHeader.appendChild(referencefield4);
          orderHeader.appendChild(referencefield5);
          orderHeader.appendChild(distributionJobNumber);
          orderHeader.appendChild(comments);
          orderHeader.appendChild(ordernotes);
          orderHeader.appendChild(shipcomplete);
          orderHeader.appendChild(orderStatusCode);
          orderHeader.appendChild(providerCode);
          orderHeader.appendChild(priorityCode);
          orderHeader.appendChild(workOrderTypeCode);
          orderHeader.appendChild(affiliateCode);
          orderHeader.appendChild(marketingSourceCode);
          orderHeader.appendChild(releaseDate);
          orderHeader.appendChild(orderSourceCode);
          orderHeader.appendChild(workOrderReference);
          orderHeader.appendChild(completeByDate);
          orderHeader.appendChild(promotionCode);
          orderHeader.appendChild(salesTerritoryCode);
          orderHeader.appendChild(billingCode);
          orderHeader.appendChild(budgetCenterCode);
          orderHeader.appendChild(exceptionType);
          orderHeader.appendChild(exceptionMessage);
          orderHeader.appendChild(createDateTime);
          orderHeader.appendChild(createDateTimeZone);
          orderHeader.appendChild(reduceInventory);
       
         Node root = document.getDocumentElement();
          NodeList nodes = root.getChildNodes();
          for (int i = 0; i < nodes.getLength(); i++) {
        	 
        	  Node node = nodes.item(i);
             
              if (node.getNodeName()=="shippingAddress") 
             	  document.renameNode(node, null, "shipToAddress");
              if (node.getNodeName()=="billingAddress") {
            	  document.renameNode(node, null, "billToAddress");
                
            	  Element salutation=doc2.createElement("salutation");
            	  Element organization=doc2.createElement("organization");
            	  
            	  
            	  Node billingAddress = doc2.importNode(node, true);
            	  billingAddress.insertBefore(organization, billingAddress.getFirstChild());
            	  billingAddress.insertBefore(salutation, billingAddress.getFirstChild());
            	
            	  orderHeader.appendChild(billingAddress );
                  
                  Element username=doc2.createElement("username");
                  username.setTextContent("email");
                  billingAddress.appendChild(username);
                  
                  Element isResidential=doc2.createElement("isResidential");
                  isResidential.setTextContent("1");
                  billingAddress.appendChild(isResidential);
                  
                  Element typeCode=doc2.createElement("typeCode");
                  typeCode.setTextContent("Customer");
                  billingAddress.appendChild(typeCode);
                  
                  Element memberID=doc2.createElement("memberID");
                  billingAddress.appendChild(memberID);
                  
                  Element memberNumber=doc2.createElement("memberNumber");
                  memberNumber.setTextContent("123456789");
                  billingAddress.appendChild(memberNumber);
                  
                  Element externMemberXRef=doc2.createElement("externMemberXRef");
                  billingAddress.appendChild(externMemberXRef);
                  
                  Element storePaymentInfo=doc2.createElement("storePaymentInfo");
                  storePaymentInfo.setTextContent("1");
                  billingAddress.appendChild(storePaymentInfo);
                  
                  Element taxNumber=doc2.createElement("taxNumber");
                  billingAddress.appendChild(taxNumber);
                  
                  Element originCode=doc2.createElement("originCode");
                  billingAddress.appendChild(originCode);
                  
                  Element sourceCode=doc2.createElement("sourceCode");
                  sourceCode.setTextContent("Test");
                  billingAddress.appendChild(sourceCode);
                  
                  Element promotionCode1=doc2.createElement("promotionCode");
                  billingAddress.appendChild(promotionCode1);
                  
                  Element priceListCode=doc2.createElement("priceListCode");
                  billingAddress.appendChild(priceListCode);
                  
                  
                  NodeList billingAddressNodes= doc2.getElementsByTagName("phoneNumber");
                  Element phoneHome = doc2.createElement("phoneHome"); 
                  billingAddressNodes.item(0).getParentNode().insertBefore(phoneHome, billingAddressNodes.item(0).getNextSibling());
                 
                  billingAddressNodes= doc2.getElementsByTagName("phoneHome");
                  Element phoneCell = doc2.createElement("phoneCell"); 
                  billingAddressNodes.item(0).getParentNode().insertBefore(phoneCell, billingAddressNodes.item(0).getNextSibling());
                  
                  billingAddressNodes= doc2.getElementsByTagName("phoneCell");
                  Element phonePager = doc2.createElement("phonePager"); 
                  billingAddressNodes.item(0).getParentNode().insertBefore(phonePager, billingAddressNodes.item(0).getNextSibling());
                  
                  billingAddressNodes= doc2.getElementsByTagName("phonePager");
                  Element phoneOther = doc2.createElement("phoneOther"); 
                  billingAddressNodes.item(0).getParentNode().insertBefore(phoneOther, billingAddressNodes.item(0).getNextSibling());
                  
                  billingAddressNodes= doc2.getElementsByTagName("phoneOther");
                  Element fax = doc2.createElement("fax"); 
                  billingAddressNodes.item(0).getParentNode().insertBefore(fax, billingAddressNodes.item(0).getNextSibling());
             
                  
              }
              /*******paymentInfo********/
              if (node.getNodeName()=="paymentInfo") {
            	  Element payments=doc2.createElement("payments");
            	  orderHeader.appendChild(payments); 
            	  
            	  Node paymentInfo = doc2.importNode(node, true);
            	  
            	  payments.appendChild(paymentInfo);
            	  //пропустить amount
            	  Element element = (Element) doc2.getElementsByTagName("amount").item(0);

            	    Node parent = element.getParentNode();
            	    parent.removeChild(element);
            	    parent.normalize();
            	    NodeList 
            	    paymentInfos= doc2.getElementsByTagName("creditCardNumber");
                    Element creditCardCid = doc2.createElement("creditCardCid"); 
                    paymentInfos.item(0).getParentNode().insertBefore(creditCardCid, paymentInfos.item(0).getNextSibling());
                    
                    
          Element bankName=doc2.createElement("bankName");
          paymentInfo.appendChild(bankName);
          
          Element bankAccountName=doc2.createElement("bankAccountName");
          paymentInfo.appendChild(bankAccountName);
          
          Element bankAbaNumber=doc2.createElement("bankAbaNumber");
          paymentInfo.appendChild(bankAbaNumber);
          
          Element bankAccountNumber=doc2.createElement("bankAccountNumber");
          paymentInfo.appendChild(bankAccountNumber);
          
          Element GiftCardNumber=doc2.createElement("GiftCardNumber");
          paymentInfo.appendChild(GiftCardNumber);
          
          Element GiftCardPin=doc2.createElement("GiftCardPin");
          paymentInfo.appendChild(GiftCardPin);
          
          Element checkNumber=doc2.createElement("checkNumber");
          paymentInfo.appendChild(checkNumber);
          
          Element bankAccountType=doc2.createElement("bankAccountType");
          paymentInfo.appendChild(bankAccountType);
          
          Element memberUsername=doc2.createElement("memberUsername");
          paymentInfo.appendChild(memberUsername);
          
          Element budgetcentercode=doc2.createElement("budgetcentercode");
          paymentInfo.appendChild(budgetcentercode);
          
          Element taxnumber=doc2.createElement("budgetcentercode");
          paymentInfo.appendChild(taxnumber);
          
          Element authorizercode=doc2.createElement("authorizercode");
          authorizercode.setTextContent("Cybersource");
          paymentInfo.appendChild(authorizercode);
          
          Element authtrnno=doc2.createElement("authtrnno");
          authtrnno.setTextContent("4781350107666096604719");
          paymentInfo.appendChild(authtrnno);
          
          Element purchaseordernumber=doc2.createElement("purchaseordernumber");
          paymentInfo.appendChild(purchaseordernumber);
          
          Element purchaseorderdate=doc2.createElement("purchaseorderdate");
          paymentInfo.appendChild(purchaseorderdate);
          
          Element purchaseorderexp=doc2.createElement("purchaseorderexp");
          paymentInfo.appendChild(purchaseorderexp);
          
          Element thirdpartyaccountnumber=doc2.createElement("thirdpartyaccountnumber");
          paymentInfo.appendChild(thirdpartyaccountnumber);
          
          Element paymenttypename=doc2.createElement("paymenttypename");
          paymenttypename.setTextContent("CC");
          paymentInfo.appendChild(paymenttypename);
          
          Element paymentstatuscode=doc2.createElement("paymentstatuscode");
          paymentstatuscode.setTextContent("completed");
          paymentInfo.appendChild(paymentstatuscode);
          
          Element transactiontypecode=doc2.createElement("transactiontypecode");
          transactiontypecode.setTextContent("AUTH_ONLY");
          paymentInfo.appendChild(transactiontypecode);
          
          Element primaryfororder=doc2.createElement("primaryfororder");
          paymentInfo.appendChild(primaryfororder);
          
          Element currencycode=doc2.createElement("currencycode");
          currencycode.setTextContent("USD");
          paymentInfo.appendChild(currencycode);
          
          Element amount=doc2.createElement("amount");
          amount.setTextContent("1070.00");
          paymentInfo.appendChild(amount);
          
          Element settleamount=doc2.createElement("settleamount");
          settleamount.setTextContent("1070.00");
          paymentInfo.appendChild(settleamount);
          
          Element settlecurrencycode=doc2.createElement("settlecurrencycode");
          settlecurrencycode.setTextContent("USD");
          paymentInfo.appendChild(settlecurrencycode);
          
          Element responsecode=doc2.createElement("responsecode");
          responsecode.setTextContent("100");
          paymentInfo.appendChild(responsecode);
          
          Element responsesubcode=doc2.createElement("responsesubcode");
          paymentInfo.appendChild(responsesubcode);
          
          Element responsereasoncode=doc2.createElement("responsereasoncode");
          paymentInfo.appendChild(responsereasoncode);
          
          Element responsereasontext=doc2.createElement("responsereasontext");
          responsereasontext.setTextContent("ACCEPT");
          paymentInfo.appendChild(responsereasontext);
          
          Element approvalcode=doc2.createElement("approvalcode");
          paymentInfo.appendChild(approvalcode);
          
          Element addressvalidationcode=doc2.createElement("addressvalidationcode");
          paymentInfo.appendChild(addressvalidationcode);
          
          Element cardcoderesponsecode=doc2.createElement("cardcoderesponsecode");
          paymentInfo.appendChild(cardcoderesponsecode);
          
          Element pmtterm=doc2.createElement("pmtterm");
          paymentInfo.appendChild(pmtterm);
          
          Element pmtmethod=doc2.createElement("pmtmethod");
          paymentInfo.appendChild(pmtmethod);
          
          Element thirdpartybillno=doc2.createElement("thirdpartybillno");
          paymentInfo.appendChild(thirdpartybillno);
          
          Element creditCardName=doc2.createElement("creditCardName");
          paymentInfo.appendChild(creditCardName);
          
          Element creditCardSuffix=doc2.createElement("creditCardSuffix");
          creditCardSuffix.setTextContent("1111");
          paymentInfo.appendChild(creditCardSuffix);
          
          Element routingNumber=doc2.createElement("routingNumber");
          paymentInfo.appendChild(routingNumber);
          
          Element creditCardType=doc2.createElement("creditCardType");
          creditCardType.setTextContent("VS");
          paymentInfo.appendChild(creditCardType);
          
          Element notes=doc2.createElement("notes");
          notes.setTextContent("Request was processed successfully.");
          paymentInfo.appendChild(notes);
          
          Element pendingreason=doc2.createElement("pendingreason");
          paymentInfo.appendChild(pendingreason);
          
          Element transactionfee=doc2.createElement("transactionfee");
          paymentInfo.appendChild(transactionfee);
          
          Element exchangerate=doc2.createElement("exchangerate");
          paymentInfo.appendChild(exchangerate);
          
          Element payerstatus=doc2.createElement("payerstatus");
          paymentInfo.appendChild(payerstatus);
          
          Element verifysign=doc2.createElement("verifysign");
          paymentInfo.appendChild(verifysign);
          
          Element paymentdate=doc2.createElement("paymentdate");
          paymentInfo.appendChild(paymentdate);
          
          Element pplsubscriberid=doc2.createElement("pplsubscriberid");
          paymentInfo.appendChild(pplsubscriberid);
          
          Element cardcode=doc2.createElement("cardcode");
          paymentInfo.appendChild(cardcode);
          
          Element credCardCid=doc2.createElement("credCardCid");
          paymentInfo.appendChild(credCardCid);
          
                    
             }  
              
          }
        
          
          ArrayList<ShippingInfo> listShippingInfo = new ArrayList();
          listShippingInfo.add(new ShippingInfo("0", "TestShipCode", "0"));
          listShippingInfo.add(new ShippingInfo("0", "TestShipCode", "0"));
          listShippingInfo.add(new ShippingInfo("0", "TestShipCode", "0"));
          
          ArrayList<Catalog> listCatalog = new ArrayList();
          listCatalog.add(new Catalog ("abc135005067","1","500.00","35.00"));
          listCatalog.add(new Catalog ("abc235005067","3","100.00","21.00"));
          listCatalog.add(new Catalog ("abc335005067","1","200.00","14.00"));
          
          Element shippingInfo = null ;
          Element catalog = null;
         
          Element orderDetail = doc2.createElement("orderDetail");
          
          ArrayList<Node> list = new ArrayList();
          list.add(orderDetail);
          list.add(orderDetail);
          list.add(orderDetail);
          
          orderHeader.appendChild(orderDetail);
          
          for (Node nod : list) { {
        	  
        	  Element orderLine= doc2.createElement("orderLine");
        	  nod .appendChild(orderLine);
        	  
        	  shippingInfo = doc2.createElement("shippingInfo");
        	  
        	  for (ShippingInfo dtl : listShippingInfo) {
                 
                   Element shippingHandling= doc2.createElement("shippingHandling");
                   shippingHandling.appendChild(doc2.createTextNode(String.valueOf(dtl.getShippingHandling())));
                   shippingInfo.appendChild(shippingHandling);
             	  Element discount= doc2.createElement("discount");
             	  shippingInfo.appendChild(discount);
             	  Element shipMethodCode= doc2.createElement("shipMethodCode");
             	  shipMethodCode.appendChild(doc2.createTextNode(String.valueOf(dtl.getShipMethodCode())));
             	  shippingInfo.appendChild(shipMethodCode);
             	  Element delayShipUntil= doc2.createElement("delayShipUntil");
             	  shippingInfo.appendChild(delayShipUntil);
             	  Element shipNotes= doc2.createElement("shipNotes");
             	  shippingInfo.appendChild(shipNotes);
             	  Element providerCode1= doc2.createElement("providerCode");
             	  shippingInfo.appendChild(providerCode1);
             	  Element shipperAttentionNeeded= doc2.createElement("shipperAttentionNeeded");
             	  shippingInfo.appendChild(shipperAttentionNeeded);
             	  Element dateNeeded= doc2.createElement("dateNeeded");
             	  shippingInfo.appendChild(dateNeeded);
             	  Element lastDropDate= doc2.createElement("lastDropDate");
             	  shippingInfo.appendChild(lastDropDate);
             	  Element declaredValue= doc2.createElement("declaredValue");
             	  shippingInfo.appendChild(declaredValue);
             	  Element insuranceCharge= doc2.createElement("insuranceCharge");
             	  shippingInfo.appendChild(insuranceCharge);
             	  Element giftMessage= doc2.createElement("giftMessage");
             	  shippingInfo.appendChild(giftMessage);
             	  Element shippingHandlingTax= doc2.createElement("shippingHandlingTax");
             	  shippingHandlingTax.appendChild(doc2.createTextNode(String.valueOf(dtl.getShippingHandlingTax())));
             	  shippingInfo.appendChild(shippingHandlingTax);
             	  Element ordertaxdetail= doc2.createElement("ordertaxdetail");
             	  shippingInfo.appendChild(ordertaxdetail);
             	  
             	  Element taxservice= doc2.createElement("taxservice");
             	  ordertaxdetail.appendChild(taxservice);
             	  Element countyname= doc2.createElement("countyname");
             	  ordertaxdetail.appendChild(countyname);
             	  Element fips= doc2.createElement("countyname");
             	  ordertaxdetail.appendChild(fips);
             	  
                  }
              orderLine.appendChild(shippingInfo);

              catalog = doc2.createElement("catalog");
              orderLine.appendChild(catalog);
              
              for(Catalog cat:listCatalog){
            	  
            	  Element catalogitem= doc2.createElement("catalogitem");
            	  catalogitem.appendChild(doc2.createTextNode(String.valueOf(cat.getCatalogitem())));
            	  catalog.appendChild(catalogitem);
            	  
            	  Element gift= doc2.createElement("gift");
            	  gift.appendChild(doc2.createTextNode(String.valueOf(cat.gift)));
            	  catalog.appendChild(gift);
            	  
            	  Element giftcharge= doc2.createElement("giftcharge");
            	  giftcharge.appendChild(doc2.createTextNode(String.valueOf(cat.giftcharge)));
            	  catalog.appendChild(giftcharge);
            	  
            	  Element  releaseDate1 = doc2.createElement("releaseDate");
              	 
            	  catalog.appendChild(releaseDate1);
            	  
            	  Element  updateTax = doc2.createElement("updateTax");
               	 
            	  catalog.appendChild(updateTax);
            	  
            	  Element  updateShipping = doc2.createElement("updateShipping");
                	 
            	  catalog.appendChild(updateShipping);
            	  
            	  Element  updatePromotion = doc2.createElement("updatePromotion");
             	 
            	  catalog.appendChild(updatePromotion);
            	  
            	  Element  checkATP= doc2.createElement("checkATP");
              	 
            	  catalog.appendChild(checkATP);
            	  
            	  Element  sku= doc2.createElement("sku");
            	  sku.appendChild(doc2.createTextNode(String.valueOf(cat.getSku())));
            	  catalog.appendChild(sku);
            	  
            	  Element  quantity= doc2.createElement("quantity");
            	  quantity.appendChild(doc2.createTextNode(String.valueOf(cat.getQuantity()))); 
            	  catalog.appendChild(quantity);
            	  
            	  Element  unitPrice= doc2.createElement("unitPrice");
            	  unitPrice.appendChild(doc2.createTextNode(String.valueOf(cat.getUnitPrice()))); 
            	  catalog.appendChild(unitPrice);
            	  
            	  Element  unitTax= doc2.createElement("unitTax");
              	 
            	  catalog.appendChild(unitTax);
            	  
            	  Element   lineTax = doc2.createElement("lineTax");
            	  lineTax.appendChild(doc2.createTextNode(String.valueOf(cat.getLineTax()))); 
            	  catalog.appendChild(lineTax);
            	  
            	  Element   PersonalizationDetails= doc2.createElement("PersonalizationDetails");
                	 
            	  catalog.appendChild(PersonalizationDetails);
            	  
            	  Element   ordertaxdetail= doc2.createElement("ordertaxdetail");
             	 
            	  catalog.appendChild(ordertaxdetail);
            	  
            	  Element   taxservice= doc2.createElement("taxservice");
              	 
            	  ordertaxdetail.appendChild(taxservice);
            	  
            	  Element   countyname= doc2.createElement("countyname");
               	 
            	  ordertaxdetail.appendChild(countyname);
            	  Element   fips= doc2.createElement("fips");
                	 
            	  ordertaxdetail.appendChild(fips);
            	  
            	  Element   initialprice= doc2.createElement("initialprice");
            	  initialprice.appendChild(doc2.createTextNode(String.valueOf(cat.getInitialprice()))); 
            	  catalog.appendChild(initialprice);  
              }
              
              Node root1 = document.getDocumentElement();
              NodeList nodes1 = root1.getChildNodes();
              for (int i = 0; i < nodes1.getLength(); i++) {
            	 
                  Node node = nodes1.item(i);
                  if (node.getNodeName()=="shipToAddress") {
                	
                	  Element salutation=doc2.createElement("salutation");
                	  Element organization=doc2.createElement("organization");
       
                	  Node shipToAddress = doc2.importNode(node, true);
                	  shipToAddress.insertBefore(organization, shipToAddress.getFirstChild());
                	  shipToAddress.insertBefore(salutation, shipToAddress.getFirstChild());
                	
                	 
                	  orderLine.appendChild(shipToAddress); 
                      
                      
                      
                      Element phoneHome = doc2.createElement("phoneHome"); 
                      
                      Element phoneCell = doc2.createElement("phoneCell"); 
                      
                      Element phonePager = doc2.createElement("phonePager"); 
                      
                      Element phoneOther = doc2.createElement("phoneOther"); 
                     
                      Element fax = doc2.createElement("fax"); 
                      shipToAddress.appendChild(phoneHome);
                      shipToAddress.appendChild(phoneCell);
                      shipToAddress.appendChild(phonePager );
                      shipToAddress.appendChild(phoneOther);
                      
                      Element username=doc2.createElement("username");
                      username.setTextContent("email");
                      shipToAddress.appendChild(username);
                      
                      Element isResidential=doc2.createElement("isResidential");
                      
                      shipToAddress.appendChild(isResidential);
                      
                      }
              
                 }

           
              }
          
          } 

    return writeDocument(doc2);
     
}

private   Object writeDocument(Document document) throws TransformerFactoryConfigurationError {
	StringWriter writer=null;
	try {
    	DOMSource domSource = new DOMSource(document);
    	 writer = new StringWriter();
    	StreamResult result = new StreamResult(writer);
    	TransformerFactory tf = TransformerFactory.newInstance();
    	Transformer transformer = tf.newTransformer();
    	transformer.transform(domSource, result);
    	
     
    } catch (Exception e) {
        e.printStackTrace(System.out);
    }
    return writer.toString();
}

}

