// $ANTLR 3.2 Sep 23, 2009 14:05:07 src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g 2011-09-30 01:45:02
 

package at.silverstrike.pcc.impl.tj3bookingsparser.grammar; 

import org.slf4j.Logger;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

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
public class BookingsParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Project", "Prj", "String", "DateTimeWithTimeZone", "Hyphen", "OpenParen", "TimeZone", "ScenarioPart1", "ScenarioPart2", "CloseParen", "Projectids", "Resource", "Identifier", "Task", "Start", "End", "Scheduling", "Asap", "Scheduled", "Supplement", "Priority", "IntegerNumber", "ProjectIdPrj", "Workinghours", "DayOfWeek", "Off", "Comma", "Time", "Colon", "Booking", "Plus", "FloatingPointNumberDuration", "FloatingPointNumber", "Overtime", "Complete", "D", "P", "H", "A", "Space"
    };
    public static final int End=19;
    public static final int FloatingPointNumberDuration=35;
    public static final int ProjectIdPrj=26;
    public static final int CloseParen=13;
    public static final int Supplement=23;
    public static final int IntegerNumber=25;
    public static final int DayOfWeek=28;
    public static final int DateTimeWithTimeZone=7;
    public static final int EOF=-1;
    public static final int Project=4;
    public static final int FloatingPointNumber=36;
    public static final int Identifier=16;
    public static final int Space=43;
    public static final int Hyphen=8;
    public static final int Overtime=37;
    public static final int OpenParen=9;
    public static final int Booking=33;
    public static final int Projectids=14;
    public static final int Scheduling=20;
    public static final int String=6;
    public static final int Task=17;
    public static final int Complete=38;
    public static final int D=39;
    public static final int Scheduled=22;
    public static final int Start=18;
    public static final int A=42;
    public static final int Prj=5;
    public static final int H=41;
    public static final int Time=31;
    public static final int Colon=32;
    public static final int P=40;
    public static final int TimeZone=10;
    public static final int Resource=15;
    public static final int Plus=34;
    public static final int Off=29;
    public static final int Priority=24;
    public static final int Asap=21;
    public static final int Comma=30;
    public static final int ScenarioPart1=11;
    public static final int Workinghours=27;
    public static final int ScenarioPart2=12;

    // delegates
    // delegators


        public BookingsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BookingsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return BookingsParser.tokenNames; }
    public String getGrammarFileName() { return "src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g"; }


    	private DefaultBookingsFile bookingsFile;
    	
    	public DefaultBookingsFile getBookingsFile()
    	{
    		return this.bookingsFile;
    	}




    // $ANTLR start "bookingsFile"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:37:1: bookingsFile : header projectIds resourceDeclaration ( task )+ (suppTask= supplementTask )* ( supplementResource )* EOF ;
    public final void bookingsFile() throws RecognitionException {
        DefaultSupplementStatement suppTask = null;


        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:38:3: ( header projectIds resourceDeclaration ( task )+ (suppTask= supplementTask )* ( supplementResource )* EOF )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:39:2: header projectIds resourceDeclaration ( task )+ (suppTask= supplementTask )* ( supplementResource )* EOF
            {

            		this.bookingsFile = new DefaultBookingsFile();
            	
            pushFollow(FOLLOW_header_in_bookingsFile43);
            header();

            state._fsp--;

            pushFollow(FOLLOW_projectIds_in_bookingsFile47);
            projectIds();

            state._fsp--;

            pushFollow(FOLLOW_resourceDeclaration_in_bookingsFile51);
            resourceDeclaration();

            state._fsp--;

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:45:3: ( task )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Task) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:45:3: task
            	    {
            	    pushFollow(FOLLOW_task_in_bookingsFile55);
            	    task();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:46:3: (suppTask= supplementTask )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Supplement) ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1==Task) ) {
                        alt2=1;
                    }


                }


                switch (alt2) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:47:4: suppTask= supplementTask
            	    {
            	    pushFollow(FOLLOW_supplementTask_in_bookingsFile67);
            	    suppTask=supplementTask();

            	    state._fsp--;

            	     this.bookingsFile.addSupplementStatement( suppTask ); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:49:3: ( supplementResource )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Supplement) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:49:3: supplementResource
            	    {
            	    pushFollow(FOLLOW_supplementResource_in_bookingsFile78);
            	    supplementResource();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,EOF,FOLLOW_EOF_in_bookingsFile83); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "bookingsFile"


    // $ANTLR start "header"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:53:1: header : Project Prj String String DateTimeWithTimeZone Hyphen DateTimeWithTimeZone OpenParen ( TimeZone )* String ScenarioPart1 OpenParen ( ScenarioPart2 )* CloseParen CloseParen ;
    public final void header() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:54:2: ( Project Prj String String DateTimeWithTimeZone Hyphen DateTimeWithTimeZone OpenParen ( TimeZone )* String ScenarioPart1 OpenParen ( ScenarioPart2 )* CloseParen CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:55:2: Project Prj String String DateTimeWithTimeZone Hyphen DateTimeWithTimeZone OpenParen ( TimeZone )* String ScenarioPart1 OpenParen ( ScenarioPart2 )* CloseParen CloseParen
            {
            match(input,Project,FOLLOW_Project_in_header96); 
            match(input,Prj,FOLLOW_Prj_in_header98); 
            match(input,String,FOLLOW_String_in_header100); 
            match(input,String,FOLLOW_String_in_header102); 
            match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_header104); 
            match(input,Hyphen,FOLLOW_Hyphen_in_header106); 
            match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_header108); 
            match(input,OpenParen,FOLLOW_OpenParen_in_header110); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:55:87: ( TimeZone )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==TimeZone) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:55:87: TimeZone
            	    {
            	    match(input,TimeZone,FOLLOW_TimeZone_in_header112); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(input,String,FOLLOW_String_in_header115); 
            match(input,ScenarioPart1,FOLLOW_ScenarioPart1_in_header119); 
            match(input,OpenParen,FOLLOW_OpenParen_in_header121); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:56:26: ( ScenarioPart2 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ScenarioPart2) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:56:26: ScenarioPart2
            	    {
            	    match(input,ScenarioPart2,FOLLOW_ScenarioPart2_in_header123); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,CloseParen,FOLLOW_CloseParen_in_header126); 
            match(input,CloseParen,FOLLOW_CloseParen_in_header130); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "header"


    // $ANTLR start "projectIds"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:75:1: projectIds : Projectids Prj ;
    public final void projectIds() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:75:11: ( Projectids Prj )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:76:2: Projectids Prj
            {
            match(input,Projectids,FOLLOW_Projectids_in_projectIds177); 
            match(input,Prj,FOLLOW_Prj_in_projectIds179); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "projectIds"


    // $ANTLR start "resourceDeclaration"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:79:1: resourceDeclaration : Resource Identifier String ;
    public final void resourceDeclaration() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:80:2: ( Resource Identifier String )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:80:4: Resource Identifier String
            {
            match(input,Resource,FOLLOW_Resource_in_resourceDeclaration190); 
            match(input,Identifier,FOLLOW_Identifier_in_resourceDeclaration192); 
            match(input,String,FOLLOW_String_in_resourceDeclaration194); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "resourceDeclaration"


    // $ANTLR start "task"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:83:1: task : Task Identifier String OpenParen ( task )* ( Start DateTimeWithTimeZone End DateTimeWithTimeZone Scheduling Asap Scheduled )* CloseParen ;
    public final void task() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:84:2: ( Task Identifier String OpenParen ( task )* ( Start DateTimeWithTimeZone End DateTimeWithTimeZone Scheduling Asap Scheduled )* CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:85:2: Task Identifier String OpenParen ( task )* ( Start DateTimeWithTimeZone End DateTimeWithTimeZone Scheduling Asap Scheduled )* CloseParen
            {
            match(input,Task,FOLLOW_Task_in_task206); 
            match(input,Identifier,FOLLOW_Identifier_in_task208); 
            match(input,String,FOLLOW_String_in_task210); 
            match(input,OpenParen,FOLLOW_OpenParen_in_task212); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:86:2: ( task )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==Task) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:86:3: task
            	    {
            	    pushFollow(FOLLOW_task_in_task216);
            	    task();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:87:2: ( Start DateTimeWithTimeZone End DateTimeWithTimeZone Scheduling Asap Scheduled )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==Start) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:87:3: Start DateTimeWithTimeZone End DateTimeWithTimeZone Scheduling Asap Scheduled
            	    {
            	    match(input,Start,FOLLOW_Start_in_task223); 
            	    match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_task225); 
            	    match(input,End,FOLLOW_End_in_task228); 
            	    match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_task230); 
            	    match(input,Scheduling,FOLLOW_Scheduling_in_task233); 
            	    match(input,Asap,FOLLOW_Asap_in_task235); 
            	    match(input,Scheduled,FOLLOW_Scheduled_in_task238); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match(input,CloseParen,FOLLOW_CloseParen_in_task243); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "task"


    // $ANTLR start "supplementTask"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:96:1: supplementTask returns [DefaultSupplementStatement suppStmt] : Supplement Task taskId= Identifier OpenParen (bStmt= booking )* Priority IntegerNumber ProjectIdPrj CloseParen ;
    public final DefaultSupplementStatement supplementTask() throws RecognitionException {
        DefaultSupplementStatement suppStmt = null;

        Token taskId=null;
        DefaultBookingStatement bStmt = null;


        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:97:2: ( Supplement Task taskId= Identifier OpenParen (bStmt= booking )* Priority IntegerNumber ProjectIdPrj CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:98:3: Supplement Task taskId= Identifier OpenParen (bStmt= booking )* Priority IntegerNumber ProjectIdPrj CloseParen
            {

            			suppStmt = new DefaultSupplementStatement();
            		
            match(input,Supplement,FOLLOW_Supplement_in_supplementTask267); 
            match(input,Task,FOLLOW_Task_in_supplementTask269); 
            taskId=(Token)match(input,Identifier,FOLLOW_Identifier_in_supplementTask273); 
            suppStmt.setTaskId((taskId!=null?taskId.getText():null)); 
            match(input,OpenParen,FOLLOW_OpenParen_in_supplementTask279); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:103:2: (bStmt= booking )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==Booking) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:104:2: bStmt= booking
            	    {
            	    pushFollow(FOLLOW_booking_in_supplementTask287);
            	    bStmt=booking();

            	    state._fsp--;

            	    suppStmt.addBookingStatement( bStmt ); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match(input,Priority,FOLLOW_Priority_in_supplementTask297); 
            match(input,IntegerNumber,FOLLOW_IntegerNumber_in_supplementTask299); 
            match(input,ProjectIdPrj,FOLLOW_ProjectIdPrj_in_supplementTask302); 
            match(input,CloseParen,FOLLOW_CloseParen_in_supplementTask305); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return suppStmt;
    }
    // $ANTLR end "supplementTask"


    // $ANTLR start "supplementResource"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:111:1: supplementResource : Supplement Resource Identifier OpenParen ( workinghours )+ CloseParen ;
    public final void supplementResource() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:112:2: ( Supplement Resource Identifier OpenParen ( workinghours )+ CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:113:2: Supplement Resource Identifier OpenParen ( workinghours )+ CloseParen
            {
            match(input,Supplement,FOLLOW_Supplement_in_supplementResource317); 
            match(input,Resource,FOLLOW_Resource_in_supplementResource319); 
            match(input,Identifier,FOLLOW_Identifier_in_supplementResource321); 
            match(input,OpenParen,FOLLOW_OpenParen_in_supplementResource323); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:114:2: ( workinghours )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==Workinghours) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:114:2: workinghours
            	    {
            	    pushFollow(FOLLOW_workinghours_in_supplementResource326);
            	    workinghours();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            match(input,CloseParen,FOLLOW_CloseParen_in_supplementResource330); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "supplementResource"


    // $ANTLR start "workinghours"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:118:1: workinghours : Workinghours DayOfWeek ( Off | workingIntervals ) ;
    public final void workinghours() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:119:2: ( Workinghours DayOfWeek ( Off | workingIntervals ) )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:120:2: Workinghours DayOfWeek ( Off | workingIntervals )
            {
            match(input,Workinghours,FOLLOW_Workinghours_in_workinghours342); 
            match(input,DayOfWeek,FOLLOW_DayOfWeek_in_workinghours344); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:120:25: ( Off | workingIntervals )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Off) ) {
                alt10=1;
            }
            else if ( (LA10_0==Time) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:120:26: Off
                    {
                    match(input,Off,FOLLOW_Off_in_workinghours347); 

                    }
                    break;
                case 2 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:120:30: workingIntervals
                    {
                    pushFollow(FOLLOW_workingIntervals_in_workinghours349);
                    workingIntervals();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "workinghours"


    // $ANTLR start "workingIntervals"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:127:1: workingIntervals : workingInterval ( Comma workingInterval )* ;
    public final void workingIntervals() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:128:2: ( workingInterval ( Comma workingInterval )* )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:129:2: workingInterval ( Comma workingInterval )*
            {
            pushFollow(FOLLOW_workingInterval_in_workingIntervals373);
            workingInterval();

            state._fsp--;

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:129:18: ( Comma workingInterval )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==Comma) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:129:19: Comma workingInterval
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_workingIntervals376); 
            	    pushFollow(FOLLOW_workingInterval_in_workingIntervals378);
            	    workingInterval();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "workingIntervals"


    // $ANTLR start "workingInterval"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:132:1: workingInterval : Time Hyphen Time ;
    public final void workingInterval() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:133:2: ( Time Hyphen Time )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:133:4: Time Hyphen Time
            {
            match(input,Time,FOLLOW_Time_in_workingInterval392); 
            match(input,Hyphen,FOLLOW_Hyphen_in_workingInterval394); 
            match(input,Time,FOLLOW_Time_in_workingInterval396); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "workingInterval"


    // $ANTLR start "booking"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:165:1: booking returns [DefaultBookingStatement stmt] : Booking resource= Identifier bt1= bookingTime ( Comma bt2= bookingTime )* ( OpenParen overtime CloseParen ) ;
    public final DefaultBookingStatement booking() throws RecognitionException {
        DefaultBookingStatement stmt = null;

        Token resource=null;
        DefaultIndBooking bt1 = null;

        DefaultIndBooking bt2 = null;


        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:166:2: ( Booking resource= Identifier bt1= bookingTime ( Comma bt2= bookingTime )* ( OpenParen overtime CloseParen ) )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:167:2: Booking resource= Identifier bt1= bookingTime ( Comma bt2= bookingTime )* ( OpenParen overtime CloseParen )
            {

            		stmt = new DefaultBookingStatement();
            	
            match(input,Booking,FOLLOW_Booking_in_booking510); 
            resource=(Token)match(input,Identifier,FOLLOW_Identifier_in_booking514); 
             stmt.setResource((resource!=null?resource.getText():null)); 
            pushFollow(FOLLOW_bookingTime_in_booking523);
            bt1=bookingTime();

            state._fsp--;

             stmt.addIndBooking(bt1); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:172:2: ( Comma bt2= bookingTime )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==Comma) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:172:3: Comma bt2= bookingTime
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_booking530); 
            	    pushFollow(FOLLOW_bookingTime_in_booking536);
            	    bt2=bookingTime();

            	    state._fsp--;

            	     stmt.addIndBooking(bt2); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:175:2: ( OpenParen overtime CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:175:3: OpenParen overtime CloseParen
            {
            match(input,OpenParen,FOLLOW_OpenParen_in_booking548); 
            pushFollow(FOLLOW_overtime_in_booking552);
            overtime();

            state._fsp--;

            match(input,CloseParen,FOLLOW_CloseParen_in_booking556); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "booking"


    // $ANTLR start "bookingTime"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:180:1: bookingTime returns [DefaultIndBooking indBooking] : startTime= DateTimeWithTimeZone Plus bookingDuration= FloatingPointNumberDuration ;
    public final DefaultIndBooking bookingTime() throws RecognitionException {
        DefaultIndBooking indBooking = null;

        Token startTime=null;
        Token bookingDuration=null;

        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:181:2: (startTime= DateTimeWithTimeZone Plus bookingDuration= FloatingPointNumberDuration )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:182:2: startTime= DateTimeWithTimeZone Plus bookingDuration= FloatingPointNumberDuration
            {
            startTime=(Token)match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_bookingTime575); 
            match(input,Plus,FOLLOW_Plus_in_bookingTime579); 
            bookingDuration=(Token)match(input,FloatingPointNumberDuration,FOLLOW_FloatingPointNumberDuration_in_bookingTime585); 

            		indBooking = new DefaultIndBooking((startTime!=null?startTime.getText():null), (bookingDuration!=null?bookingDuration.getText():null));
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return indBooking;
    }
    // $ANTLR end "bookingTime"


    // $ANTLR start "duration"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:205:1: duration : FloatingPointNumber 'h' ;
    public final void duration() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:206:2: ( FloatingPointNumber 'h' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:207:2: FloatingPointNumber 'h'
            {
            match(input,FloatingPointNumber,FOLLOW_FloatingPointNumber_in_duration637); 
            match(input,H,FOLLOW_H_in_duration639); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "duration"


    // $ANTLR start "overtime"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:210:1: overtime : Overtime IntegerNumber ;
    public final void overtime() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:211:2: ( Overtime IntegerNumber )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:212:2: Overtime IntegerNumber
            {
            match(input,Overtime,FOLLOW_Overtime_in_overtime651); 
            match(input,IntegerNumber,FOLLOW_IntegerNumber_in_overtime653); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "overtime"

    // Delegated rules


 

    public static final BitSet FOLLOW_header_in_bookingsFile43 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_projectIds_in_bookingsFile47 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_resourceDeclaration_in_bookingsFile51 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_task_in_bookingsFile55 = new BitSet(new long[]{0x0000000000820000L});
    public static final BitSet FOLLOW_supplementTask_in_bookingsFile67 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_supplementResource_in_bookingsFile78 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_EOF_in_bookingsFile83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Project_in_header96 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Prj_in_header98 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_String_in_header100 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_String_in_header102 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_DateTimeWithTimeZone_in_header104 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_Hyphen_in_header106 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_DateTimeWithTimeZone_in_header108 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OpenParen_in_header110 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_TimeZone_in_header112 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_String_in_header115 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ScenarioPart1_in_header119 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OpenParen_in_header121 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_ScenarioPart2_in_header123 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_CloseParen_in_header126 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CloseParen_in_header130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Projectids_in_projectIds177 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Prj_in_projectIds179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Resource_in_resourceDeclaration190 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_Identifier_in_resourceDeclaration192 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_String_in_resourceDeclaration194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Task_in_task206 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_Identifier_in_task208 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_String_in_task210 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OpenParen_in_task212 = new BitSet(new long[]{0x0000000000062000L});
    public static final BitSet FOLLOW_task_in_task216 = new BitSet(new long[]{0x0000000000062000L});
    public static final BitSet FOLLOW_Start_in_task223 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_DateTimeWithTimeZone_in_task225 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_End_in_task228 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_DateTimeWithTimeZone_in_task230 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_Scheduling_in_task233 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_Asap_in_task235 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Scheduled_in_task238 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_CloseParen_in_task243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Supplement_in_supplementTask267 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_Task_in_supplementTask269 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_Identifier_in_supplementTask273 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OpenParen_in_supplementTask279 = new BitSet(new long[]{0x0000000201000000L});
    public static final BitSet FOLLOW_booking_in_supplementTask287 = new BitSet(new long[]{0x0000000201000000L});
    public static final BitSet FOLLOW_Priority_in_supplementTask297 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_IntegerNumber_in_supplementTask299 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_ProjectIdPrj_in_supplementTask302 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CloseParen_in_supplementTask305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Supplement_in_supplementResource317 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_Resource_in_supplementResource319 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_Identifier_in_supplementResource321 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OpenParen_in_supplementResource323 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_workinghours_in_supplementResource326 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_CloseParen_in_supplementResource330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Workinghours_in_workinghours342 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_DayOfWeek_in_workinghours344 = new BitSet(new long[]{0x00000000A0000000L});
    public static final BitSet FOLLOW_Off_in_workinghours347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_workingIntervals_in_workinghours349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_workingInterval_in_workingIntervals373 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_Comma_in_workingIntervals376 = new BitSet(new long[]{0x00000000A0000000L});
    public static final BitSet FOLLOW_workingInterval_in_workingIntervals378 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_Time_in_workingInterval392 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_Hyphen_in_workingInterval394 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_Time_in_workingInterval396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Booking_in_booking510 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_Identifier_in_booking514 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_bookingTime_in_booking523 = new BitSet(new long[]{0x0000000040000200L});
    public static final BitSet FOLLOW_Comma_in_booking530 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_bookingTime_in_booking536 = new BitSet(new long[]{0x0000000040000200L});
    public static final BitSet FOLLOW_OpenParen_in_booking548 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_overtime_in_booking552 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CloseParen_in_booking556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DateTimeWithTimeZone_in_bookingTime575 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_Plus_in_bookingTime579 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_FloatingPointNumberDuration_in_bookingTime585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FloatingPointNumber_in_duration637 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_H_in_duration639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Overtime_in_overtime651 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_IntegerNumber_in_overtime653 = new BitSet(new long[]{0x0000000000000002L});

}