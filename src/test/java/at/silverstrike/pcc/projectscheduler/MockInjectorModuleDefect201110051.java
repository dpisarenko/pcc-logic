package at.silverstrike.pcc.projectscheduler;

import at.silverstrike.pcc.api.embeddedfilereading.EmbeddedFileReader;
import at.silverstrike.pcc.api.export2tj3.TaskJuggler3Exporter;
import at.silverstrike.pcc.api.gcaltasks2pccimporter.GoogleCalendarTasks2PccImporter2Factory;
import at.silverstrike.pcc.api.gtask2pcctaskconverter.GoogleTask2PccTaskConverterFactory;
import at.silverstrike.pcc.api.gtasknoteparser.GoogleTaskNotesParserFactory;
import at.silverstrike.pcc.api.gtaskprioritycalculator.GoogleTasksPriorityCalculatorFactory;
import at.silverstrike.pcc.api.gtaskrelevance.IsGoogleTaskRelevantCalculatorFactory;
import at.silverstrike.pcc.api.gtaskrelevance2.RelevantTaskSetCalculatorFactory;
import at.silverstrike.pcc.api.gtasktitleparser.GoogleTaskTitleParserFactory;
import at.silverstrike.pcc.api.persistence.Persistence;
import at.silverstrike.pcc.api.projectscheduler.ProjectScheduler;
import at.silverstrike.pcc.api.tj3bookingsparser.BookingsFile2BookingsFactory;
import at.silverstrike.pcc.api.tj3bookingsparser.Tj3BookingsParserFactory;
import at.silverstrike.pcc.api.tj3deadlinesparser.Tj3DeadlinesFileParserFactory;
import at.silverstrike.pcc.impl.embeddedfilereading.DefaultEmbeddedFileReaderFactory;
import at.silverstrike.pcc.impl.export2tj3.DefaultTaskJuggler3ExporterFactory;
import at.silverstrike.pcc.impl.gcaltasks2pccimporter.DefaultGoogleCalendarTasks2PccImporter2Factory;
import at.silverstrike.pcc.impl.gtask2pcctaskconverter.DefaultGoogleTask2PccTaskConverterFactory;
import at.silverstrike.pcc.impl.gtasknoteparser.DefaultGoogleTaskNotesParserFactory;
import at.silverstrike.pcc.impl.gtaskprioritycalculator.DefaultGoogleTasksPriorityCalculatorFactory;
import at.silverstrike.pcc.impl.gtaskrelevance.DefaultIsGoogleTaskRelevantCalculatorFactory;
import at.silverstrike.pcc.impl.gtaskrelevance2.DefaultRelevantTaskSetCalculatorFactory;
import at.silverstrike.pcc.impl.gtasktitleparser.DefaultGoogleTaskTitleParserFactory;
import at.silverstrike.pcc.impl.projectscheduler.DefaultProjectSchedulerFactory;
import at.silverstrike.pcc.impl.tj3bookingsparser.DefaultBookingsFile2BookingsFactory;
import at.silverstrike.pcc.impl.tj3bookingsparser.DefaultTj3BookingsParserFactory;
import at.silverstrike.pcc.impl.tj3deadlinesparser.DefaultTj3DeadlinesFileParserFactory;

import co.altruix.pcc.api.calendarevent2pcceventconverter.CalendarEventEntry2PccEventConverterFactory;
import co.altruix.pcc.impl.calendarevent2pcceventconverter.DefaultCalendarEventEntry2PccEventConverterFactory;

import com.google.inject.AbstractModule;

public class MockInjectorModuleDefect201110051 extends AbstractModule {
    private Persistence persistence;

    public MockInjectorModuleDefect201110051(final Persistence aPersistence) {
        this.persistence = aPersistence;
    }

    @Override
    protected void configure() {
        bind(ProjectScheduler.class).toInstance(
                new DefaultProjectSchedulerFactory().create());
        bind(TaskJuggler3Exporter.class).toInstance(
                new DefaultTaskJuggler3ExporterFactory().create());
        bind(Persistence.class).toInstance(this.persistence);
        bind(EmbeddedFileReader.class).toInstance(
                new DefaultEmbeddedFileReaderFactory().create());
        bind(Tj3DeadlinesFileParserFactory.class)
                .toInstance(new DefaultTj3DeadlinesFileParserFactory());
        bind(Tj3BookingsParserFactory.class).
                toInstance(new DefaultTj3BookingsParserFactory());
        bind(BookingsFile2BookingsFactory.class).
                toInstance(new DefaultBookingsFile2BookingsFactory());
        bind(GoogleCalendarTasks2PccImporter2Factory.class).toInstance(
                new DefaultGoogleCalendarTasks2PccImporter2Factory());
        bind(IsGoogleTaskRelevantCalculatorFactory.class).toInstance(
                new DefaultIsGoogleTaskRelevantCalculatorFactory());
        bind(GoogleTaskNotesParserFactory.class).toInstance(
                new DefaultGoogleTaskNotesParserFactory());
        bind(GoogleTask2PccTaskConverterFactory.class).toInstance(
                new DefaultGoogleTask2PccTaskConverterFactory());
        bind(GoogleTaskTitleParserFactory.class).toInstance(
                new DefaultGoogleTaskTitleParserFactory());
        bind(RelevantTaskSetCalculatorFactory.class).toInstance(
                new DefaultRelevantTaskSetCalculatorFactory());
        bind(CalendarEventEntry2PccEventConverterFactory.class).toInstance(
                new DefaultCalendarEventEntry2PccEventConverterFactory());
        bind(GoogleTasksPriorityCalculatorFactory.class).toInstance(
                new DefaultGoogleTasksPriorityCalculatorFactory());
    }

}
