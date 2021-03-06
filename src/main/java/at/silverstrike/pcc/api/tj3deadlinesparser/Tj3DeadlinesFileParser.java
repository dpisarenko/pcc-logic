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

package at.silverstrike.pcc.api.tj3deadlinesparser;

import java.util.List;

import ru.altruix.commons.api.conventions.SingleActivityModule;
import ru.altruix.commons.api.di.ModuleWithInjectableDependencies;
import ru.altruix.commons.api.di.PccException;


/**
 * Interface of an object for reading and parsing CSV files with process end
 * times. These files are generated by TaskJuggler III and a sample file can be
 * found in pcc\doc\2010_05_28_prototype1\ref\deadlines.csv.
 * 
 * The file consists of lines with two pieces of data - task ID and its end
 * time.
 * 
 * Note that in the file the process IDs are given as "Tx" where x is the
 * process ID. So, when parsing the file, we should strip the T.
 * 
 * @author Dmitri Pisarenko
 */
public interface Tj3DeadlinesFileParser extends
        ModuleWithInjectableDependencies, SingleActivityModule {
    /**
     * @param Input
     *            stream with CSV deadline file.
     */
    void setInputFileName(final String aInputFileName);

    /**
     * Parses the file (given via setInputStream method) and saves the result in
     * processEndTimes property.
     */
    void run() throws PccException;

    /**
     * @return Process end time information contained in the CSV deadline file.
     */
    List<ProcessEndTimeTuple> getProcessEndTimes();
}
