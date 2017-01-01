<%@ taglib uri="struts-html" prefix="html" %>
<%@ taglib uri="struts-logic" prefix="logic" %>
<%@ taglib uri="struts-bean" prefix="bean" %>

		<tr>
			<td>UserId:</td>
			<td><html:text property="userId"/></td>
		</tr>
		<tr>
			<td>Name:</td>
			<td><html:text property="name"/></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><html:password property="password"/></td>
		</tr>
		<tr>
			<td>AuthorityId:</td>
			<td>
                            
                            <html:select property="authorityId">
                                <html:options collection="authorityList" property="authorityId" labelProperty="description"/>
                            </html:select>
                        </td>
		</tr>
                <%--
		<tr>
			<td>DistrictId:</td>
			<td>                            
                            <html:select property="districtId">
                                <html:options collection="districtList" property="districtId" labelProperty="districtId"/>
                            </html:select>
                        </td>
		</tr>
                --%>
