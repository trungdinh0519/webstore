<%@ include file="/common/taglibs.jsp"%>
<!-- specify this transaction as a single item, cartless transaction -->
<input type="hidden" name="cmd" 				value="_xclick"/>
<!-- email address for store's paypal account -->
<input type="hidden" name="business" 			value="<c:out value="${business_email}"/>"/>
<!-- total cost before shipping &amp; handling and taxes. in this case, simply the item cost -->
<input type="hidden" name="amount" 				value="<c:out value="${product.price/16000}"/>"/>
<!-- description of item -->
<input type="hidden" name="item_name" 			value="<c:out value="${product.name}"/>"/>
<!-- in this case, quantity is always one -->
<input type="hidden" name="quantity" 			value="1"/>
<!-- set to 1 so user can change quantity -->
<input type="hidden" name="undefined_quantity" 	value="1"/>
<!-- set to 0 so user will be asked to provide a note during purchasing --> 
<input type="hidden" name="no_note" 			value="0"/>
<!-- set to 2 to require a shipping address after the jump -->
<input type="hidden" name="no_shipping" 		value="2"/>
<!-- where to send user from the jump if cancel while there, which is fully qualified URL to this page (including port) -->
<input type="hidden" name="cancel_return" 		value="<c:out value="${cancel_returnURL}"/>"/>
<!-- where to send user after completes jump which is fully qualified URL to this page (including port) -->
<input type="hidden" name="return" 				value="<c:out value="${returnURL}"/>"/>
<input type="hidden" name="notify_url" 				value="<c:out value="${notify_url}"/>"/>
<!-- set to 1 to force the use of a GET request when returning the user from the jump -->
<input type="hidden" name="rm"					value="1"/>
<input type="hidden" name="currency_code" value="USD"/>