package at.uibk.dps.afcl.functions.objects;

import at.uibk.dps.afcl.functions.AtomicFunction;
import at.uibk.dps.afcl.functions.Compound;
import org.junit.Assert;
import org.junit.Test;
import org.meanbean.test.BeanTester;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Test the functionality of a parallel-section object.
 *
 * @author stefanpedratscher
 */
public class SectionTest {
    /**
     * Test full construction of a section.
     *
     * @author stefanpedratscher
     */
    @Test
    public void testFullConstruction() {
        final AtomicFunction atomicFunction = new AtomicFunction("atomicFunction", "atomicFunctionType", null, null);

        final Section section = new Section(new ArrayList<>(Collections.singleton(atomicFunction)));

        Assert.assertEquals(1, section.getSection().size());
        Assert.assertEquals(atomicFunction, section.getSection().get(0));
        Assert.assertEquals(0, section.getAdditionalProperties().size());
    }

    /**
     * Test the empty construction of a section.
     *
     * @author stefanpedratscher
     */
    @Test
    public void testEmptyConstruction() {
        final Section section = new Section();

        Assert.assertNull(section.getSection());
        Assert.assertEquals(0, section.getAdditionalProperties().size());
    }

    /**
     * Test getter and setter
     *
     * @author stefanpedratscher
     */
    @Test
    public void testGetterAndSetter() {
        new BeanTester().testBean(Section.class);
    }

    /**
     * Test hashCode and equals
     *
     * @author stefanpedratscher
     */
    @Test
    public void testHashEquals() {
        final AtomicFunction atomicFunction = new AtomicFunction("atomicFunction", "atomicFunctionType", null, null);

        final Section section = new Section(new ArrayList<>(Collections.singleton(atomicFunction)));

        Assert.assertEquals(section, section);
        Assert.assertEquals(section.hashCode(), section.hashCode());
        Assert.assertNotEquals(section, null);

        final Compound compound = new Compound();
        Assert.assertNotEquals(section, compound);

        final Section section2 = new Section(new ArrayList<>(Collections.singleton(atomicFunction)));
        Assert.assertEquals(section, section2);
        Assert.assertEquals(section.hashCode(), section2.hashCode());
        section2.setAdditionalProperties("name", "type");
        Assert.assertNotEquals(section, section2);

        final Section section3= new Section(new ArrayList<>(Collections.singleton(new AtomicFunction())));
        Assert.assertNotEquals(section, section3);
    }
}
