/**
 * This file is part of Project Control Center (PCC).
 * 
 * PCC (Project Control Center) project is intellectual property of 
 * Dmitri Anatol'evich Pisarenko.
 * 
 * Copyright 2010, 2011 Dmitri Anatol'evich Pisarenko
 * All rights reserved
 *
 **/

package at.silverstrike.pcc.tj3bookingsparser;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.io.File;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Before;
import org.junit.Test;

import at.silverstrike.pcc.api.tj3bookingsparser.BookingStatement;
import at.silverstrike.pcc.api.tj3bookingsparser.BookingsFile;
import at.silverstrike.pcc.api.tj3bookingsparser.IndBooking;
import at.silverstrike.pcc.api.tj3bookingsparser.SupplementStatement;
import at.silverstrike.pcc.impl.tj3bookingsparser.grammar.BookingsLexer;
import at.silverstrike.pcc.impl.tj3bookingsparser.grammar.BookingsParser;

public final class TestBookingsParser {
    private static final String DIR = "src/test/resources/at/silverstrike/"
            + "pcc/test/tj3bookingsparser/";
    private static final Logger LOGGER =
            LoggerFactory.getLogger(TestBookingsParser.class);

    @Before
    public void setupLogger() {
    }

    @Test
    public void test01() {
        BookingsFile bookingsFile = null;
        InputStream inputStream = null;
        try {
            inputStream = FileUtils.openInputStream(new File(DIR + "test01"));
            final BookingsLexer lexer =
                    new BookingsLexer(new ANTLRInputStream(inputStream));
            final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            final BookingsParser parser = new BookingsParser(tokenStream);

            parser.bookingsFile();
            checkParsingErrors(parser);
            bookingsFile = parser.getBookingsFile();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        } finally {
            IOUtils.closeQuietly(inputStream);
        }

        assertNotNull(bookingsFile);

        final List<SupplementStatement> supplementStatements =
                bookingsFile.getSupplementStatements();

        assertNotNull(supplementStatements);
        assertEquals(1, supplementStatements.size());

        final SupplementStatement supplementStatement =
                supplementStatements.get(0);

        final List<BookingStatement> bookingStatements =
                supplementStatement.getBookingStatements();

        assertNotNull(bookingStatements);
        assertEquals(1, bookingStatements.size());

        final BookingStatement bookingStatement = bookingStatements.get(0);

        assertEquals("R1210", bookingStatement.getResource());

        final List<IndBooking> indBookings = bookingStatement.getIndBookings();

        assertNotNull(indBookings);
        assertEquals(1, indBookings.size());

        final IndBooking indBooking = indBookings.get(0);

        LOGGER.debug("indBooking.getDuration(): " + indBooking.getDuration());

        Assert
                .assertEquals("2010-10-25-09:00-+0200", indBooking
                        .getStartTime());
        Assert.assertEquals("2.75h", indBooking.getDuration());
    }

    @Test
    /**
     * 201108/5
     * evernote:///view/3784753/s35/ca00cf14-68bc-4889-82f4-c3de6d59cca3/ca00cf14-68bc-4889-82f4-c3de6d59cca3/
     */
    public void testDefect_201108_5() {
        BookingsFile bookingsFile = null;
        InputStream inputStream = null;
        try {
            inputStream =
                    FileUtils.openInputStream(new File(DIR
                            + "testDefect_201108_5"));
            final BookingsLexer lexer =
                    new BookingsLexer(new ANTLRInputStream(inputStream));
            final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            final BookingsParser parser = new BookingsParser(tokenStream);

            parser.bookingsFile();
            checkParsingErrors(parser);
            bookingsFile = parser.getBookingsFile();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        } finally {
            IOUtils.closeQuietly(inputStream);
        }

        assertNotNull(bookingsFile);
        assertNotNull(bookingsFile.getSupplementStatements());
        assertEquals(5, bookingsFile.getSupplementStatements().size());

    }

    @Test
    /**
     * 201108/5
     * evernote:///view/3784753/s35/ca00cf14-68bc-4889-82f4-c3de6d59cca3/ca00cf14-68bc-4889-82f4-c3de6d59cca3/
     */
    public void testDefect_201108_5_2() {
        BookingsFile bookingsFile = null;
        InputStream inputStream = null;
        try {
            inputStream =
                    FileUtils.openInputStream(new File(DIR
                            + "testDefect_201108_5_2"));
            final BookingsLexer lexer =
                    new BookingsLexer(new ANTLRInputStream(inputStream));
            final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            final BookingsParser parser = new BookingsParser(tokenStream);

            parser.bookingsFile();
            checkParsingErrors(parser);
            bookingsFile = parser.getBookingsFile();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        } finally {
            IOUtils.closeQuietly(inputStream);
        }

        assertNotNull(bookingsFile);
        assertNotNull(bookingsFile.getSupplementStatements());
        assertEquals(5, bookingsFile.getSupplementStatements().size());

        final SupplementStatement stmt1 =
                bookingsFile.getSupplementStatements().get(0);
        assertEquals(1, stmt1.getBookingStatements().size());

        final BookingStatement bookingStmt1 =
                stmt1.getBookingStatements().get(0);

        assertEquals("R22", bookingStmt1.getResource());
        assertEquals(1, bookingStmt1.getIndBookings().size());

        final IndBooking indBooking = bookingStmt1.getIndBookings().get(0);
        assertEquals("2.0h", indBooking.getDuration());

    }

    @Test
    public void testParsingError20110930() {
        InputStream inputStream = null;
        try {
            inputStream =
                    FileUtils.openInputStream(new File(DIR
                            + "testParsingError20110930"));
            final BookingsLexer lexer =
                    new BookingsLexer(new ANTLRInputStream(inputStream));
            final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            final BookingsParser parser = new BookingsParser(tokenStream);

            parser.bookingsFile();
            checkParsingErrors(parser);
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    @Test
    public void testAlapParsingError20111005() {
        InputStream inputStream = null;
        try {
            inputStream =
                    FileUtils.openInputStream(new File(DIR
                            + "testAlapParsingError20111005"));
            final BookingsLexer lexer =
                    new BookingsLexer(new ANTLRInputStream(inputStream));
            final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            final BookingsParser parser = new BookingsParser(tokenStream);

            parser.bookingsFile();
            checkParsingErrors(parser);
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    @Test
    public void testDefect201110112() {
        InputStream inputStream = null;
        BookingsFile bookingsFile = null;
        try {
            inputStream =
                    FileUtils.openInputStream(new File(DIR
                            + "testDefect_201110112.tji.tjp"));
            final BookingsLexer lexer =
                    new BookingsLexer(new ANTLRInputStream(inputStream));
            final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            final BookingsParser parser = new BookingsParser(tokenStream);

            parser.bookingsFile();
            checkParsingErrors(parser);
            bookingsFile = parser.getBookingsFile();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        } finally {
            IOUtils.closeQuietly(inputStream);
        }

        Assert.assertNotNull(bookingsFile);
        
        final List<String> taskNames = new LinkedList<String>();
        
        for (final SupplementStatement curSuppStmt : bookingsFile.getSupplementStatements())
        {
            taskNames.add(curSuppStmt.getTaskId());
        }
        

        Assert.assertEquals(4, taskNames.size());
    }

    @Test
    public void testFile20120210() {
        InputStream inputStream = null;
        BookingsFile bookingsFile = null;
        try {
            inputStream =
                    FileUtils.openInputStream(new File(DIR
                            + "test_20120210.tji.tjp"));
            final BookingsLexer lexer =
                    new BookingsLexer(new ANTLRInputStream(inputStream));
            final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            final BookingsParser parser = new BookingsParser(tokenStream);

            parser.bookingsFile();
            checkParsingErrors(parser);
            bookingsFile = parser.getBookingsFile();
        } catch (final Exception exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        } finally {
            IOUtils.closeQuietly(inputStream);
        }

        Assert.assertNotNull(bookingsFile);
        
        final List<String> taskNames = new LinkedList<String>();
        
        for (final SupplementStatement curSuppStmt : bookingsFile.getSupplementStatements())
        {
            taskNames.add(curSuppStmt.getTaskId());
        }
        
        Assert.assertEquals(1, taskNames.size());
    }

    
    private void checkParsingErrors(final BookingsParser parser) {
        Assert.assertEquals("Parsing error(s) occured", 0,
                parser.getNumberOfSyntaxErrors());
    }
}
