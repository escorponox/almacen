<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:ns2="http://www.carlos.coves.com/jaxb"
                version="1.0">

    <xsl:template match="/">
        <div class="table-responsive">
            <h2>Item List</h2>
            <table class="table table-striped table-hover table-condensed">
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Location</th>
                    <th>Stock</th>
                    <th>Min Stock</th>
                    <th>Max Stock</th>
                </tr>
                <xsl:for-each select="ns2:itemList/items/item">
                    <tr>
                        <td>
                            <xsl:value-of select="code"/>
                        </td>
                        <td>
                            <xsl:value-of select="name"/>
                        </td>
                        <td>
                            <xsl:value-of select="description"/>
                        </td>
                        <td>
                            <xsl:value-of select="price"/>
                        </td>
                        <td>
                            <xsl:value-of select="location"/>
                        </td>
                        <td>
                            <xsl:value-of select="stock"/>
                        </td>
                        <td>
                            <xsl:value-of select="minStock"/>
                        </td>
                        <td>
                            <xsl:value-of select="maxStock"/>
                        </td>
                    </tr>
                </xsl:for-each>
            </table>
        </div>
    </xsl:template>

</xsl:stylesheet>