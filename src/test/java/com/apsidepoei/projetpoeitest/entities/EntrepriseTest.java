package com.apsidepoei.projetpoeitest.entities;

import org.junit.Assert;
import org.junit.Test;

import com.apsidepoei.projetpoei.entities.Entreprise;

/**
 * 
 * @author benjamin-m
 *
 */
public class EntrepriseTest {

	@Test
    public void testToString()
    {
        Entreprise entreprise = new Entreprise("entreprise1", "antenne1", "53267126000018", "0000A");
        entreprise.setId(1);
        System.out.println(entreprise.toString());
        String expected = "Entreprise [Id = 1, nom = entreprise1, nomAntenne = antenne1, siret = 53267126000018, codeApe = 0000A]";
        Assert.assertEquals(expected, entreprise.toString());
    }
}
