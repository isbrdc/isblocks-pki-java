/*************************************************************************
 *                                                                       *
 *  EJBCA Community: The OpenSource Certificate Authority                *
 *                                                                       *
 *  This software is free software; you can redistribute it and/or       *
 *  modify it under the terms of the GNU Lesser General Public           *
 *  License as published by the Free Software Foundation; either         *
 *  version 2.1 of the License, or any later version.                    *
 *                                                                       *
 *  See terms of license at gnu.org.                                     *
 *                                                                       *
 *************************************************************************/
package org.ejbca.core.model.ca.certificateprofiles;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.bouncycastle.asn1.x509.PolicyQualifierId;


/** NOTE! This class is only kept for upgrade and backwards compatibility purposes.
 * Replaced by org.cesecore.certificates.certificateprofile.CertificatePolicy
 * 
 * @version $Id$
 */
public class CertificatePolicy implements Serializable, Cloneable {

	/** Warning changing this value will cause upgrades to fail, because
	 * it has been serialized in the database (in XML).
	 * DONT CHANGE THIS!
	 */
    private static final long serialVersionUID = -6384137742329979249L;

    // Policy qualifier Ids are taken from BC classes
    public static final String id_qt_cps = PolicyQualifierId.id_qt_cps.getId();
    public static final String id_qt_unotice = PolicyQualifierId.id_qt_unotice.getId();
    
    /**
     * The special <code>anyPolicy</code> policy OID.
     */
    public static final String ANY_POLICY_OID = "2.5.29.32.0";
    
    private String policyID;
    /** CPS uri */
    private String qualifierId;
    /** user notice text */
    private String qualifier;

    public CertificatePolicy() {
        super();
    }

    /**
     * 
     * @param policyID
     * @param notice user notice text
     * @param uri cps uri
     */
    public CertificatePolicy(final String policyID, final String qualifierId, final String qualifier) {
        this.policyID = policyID;
        this.qualifierId = qualifierId;
        this.qualifier = qualifier;
    }

    /**
     * @return the policyID
     */
    public String getPolicyID() {
        return this.policyID;
    }

    /**
     * @param policyID the policyID to set
     */
    public void setPolicyID(final String policyID) {
        this.policyID = policyID;
    }

    
    /**
     * @return the qualifier string
     */
    public String getQualifier() {
        return this.qualifier;
    }

    
    /**
     * @param uri the uri to set
     */
    public void setQualifier(final String qualifier) {
        this.qualifier = qualifier;
    }

    /**
     * @return the QualifierId
     */
    public String getQualifierId() {
        return this.qualifierId;
    }

    
    /**
     * @param qualifierId the QualifierId to set
     */
    public void setQualifierId(final String qualifierId) {
        this.qualifierId = qualifierId;
    }
    
    /**
     * @see java.lang.Object#clone()
     */
    @Override
    protected Object clone() throws CloneNotSupportedException { // NOPMD by tomas on 1/7/11 1:04 PM
        return new CertificatePolicy(this.policyID, this.qualifierId, this.qualifier);
    }

    /** @see java.lang.Object#toString() */
    @Override
    public String toString() {
        final StringBuilder strBuffer = new StringBuilder(100);
        strBuffer.append("CertificatePolicy(policyID=");
        strBuffer.append(this.policyID);
        strBuffer.append(", qualifierId=");
        strBuffer.append(this.qualifierId);
        strBuffer.append(", qualifier=");
        strBuffer.append(this.qualifier);
        strBuffer.append(')');
        return strBuffer.toString();
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if((obj == null) || !(obj instanceof CertificatePolicy)) {
            return false;
        }
        final CertificatePolicy policy = (CertificatePolicy) obj;

        // We want to let both null and "" be the same value here, i.e. an empty value
        // Simply because, especially in GUI code, it is somewhat tricky to trust which is a non-existent value
        boolean policyEqual = false;
        if (StringUtils.isEmpty(policy.getPolicyID()) && StringUtils.isEmpty(this.policyID)) {
            policyEqual = true;
        } else if (StringUtils.equals(policy.getPolicyID(), this.policyID)) {
            policyEqual = true;
        }
        boolean qualifierIdsEqual = false;
        if (StringUtils.isEmpty(policy.getQualifierId()) && StringUtils.isEmpty(this.qualifierId)) {
            qualifierIdsEqual = true;
        } else if (StringUtils.equals(policy.getQualifierId(), this.qualifierId)) {
            qualifierIdsEqual = true;
        }
        boolean qualifiersEqual = false;
        if (StringUtils.isEmpty(policy.getQualifier()) && StringUtils.isEmpty(this.qualifier)) {
            qualifiersEqual = true;
        } else if (StringUtils.equals(policy.getQualifier(), this.qualifier)) {
            qualifiersEqual = true;
        }
        return policyEqual && qualifierIdsEqual && qualifiersEqual; 
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

}
