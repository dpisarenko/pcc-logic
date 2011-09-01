// $ANTLR 3.2 Sep 23, 2009 14:05:07 src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g 2011-09-02 01:37:16
 

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Project", "Prj", "String", "DateTimeWithTimeZone", "Hyphen", "OpenParen", "CloseParen", "TimeZone", "Utc", "A", "Projectids", "Resource", "Identifier", "Task", "Start", "End", "Scheduling", "Asap", "Scheduled", "Supplement", "Priority", "IntegerNumber", "Workinghours", "DayOfWeek", "Off", "Comma", "Time", "Colon", "Booking", "Plus", "FloatingPointNumberDuration", "FloatingPointNumber", "Overtime", "Complete", "D", "P", "H", "Space"
    };
    public static final int D=38;
    public static final int Scheduled=22;
    public static final int End=19;
    public static final int FloatingPointNumberDuration=34;
    public static final int Start=18;
    public static final int A=13;
    public static final int Prj=5;
    public static final int CloseParen=10;
    public static final int IntegerNumber=25;
    public static final int Supplement=23;
    public static final int H=40;
    public static final int DayOfWeek=27;
    public static final int DateTimeWithTimeZone=7;
    public static final int Utc=12;
    public static final int Time=30;
    public static final int Colon=31;
    public static final int P=39;
    public static final int EOF=-1;
    public static final int FloatingPointNumber=35;
    public static final int Project=4;
    public static final int TimeZone=11;
    public static final int Identifier=16;
    public static final int Space=41;
    public static final int Plus=33;
    public static final int Hyphen=8;
    public static final int Resource=15;
    public static final int Off=28;
    public static final int Overtime=36;
    public static final int OpenParen=9;
    public static final int Booking=32;
    public static final int Priority=24;
    public static final int Projectids=14;
    public static final int Scheduling=20;
    public static final int String=6;
    public static final int Task=17;
    public static final int Asap=21;
    public static final int Comma=29;
    public static final int Complete=37;
    public static final int Workinghours=26;

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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:53:1: header : Project Prj String String DateTimeWithTimeZone Hyphen DateTimeWithTimeZone OpenParen timeZone CloseParen ;
    public final void header() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:54:2: ( Project Prj String String DateTimeWithTimeZone Hyphen DateTimeWithTimeZone OpenParen timeZone CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:55:2: Project Prj String String DateTimeWithTimeZone Hyphen DateTimeWithTimeZone OpenParen timeZone CloseParen
            {
            match(input,Project,FOLLOW_Project_in_header96); 
            match(input,Prj,FOLLOW_Prj_in_header98); 
            match(input,String,FOLLOW_String_in_header100); 
            match(input,String,FOLLOW_String_in_header102); 
            match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_header104); 
            match(input,Hyphen,FOLLOW_Hyphen_in_header106); 
            match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_header108); 
            match(input,OpenParen,FOLLOW_OpenParen_in_header110); 
            pushFollow(FOLLOW_timeZone_in_header112);
            timeZone();

            state._fsp--;

            match(input,CloseParen,FOLLOW_CloseParen_in_header114); 

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


    // $ANTLR start "timeZone"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:58:1: timeZone : TimeZone Utc ;
    public final void timeZone() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:59:2: ( TimeZone Utc )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:60:2: TimeZone Utc
            {
            match(input,TimeZone,FOLLOW_TimeZone_in_timeZone127); 
            match(input,Utc,FOLLOW_Utc_in_timeZone129); 

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
    // $ANTLR end "timeZone"


    // $ANTLR start "projectIds"
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:73:1: projectIds : Projectids Prj ;
    public final void projectIds() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:73:11: ( Projectids Prj )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:74:2: Projectids Prj
            {
            match(input,Projectids,FOLLOW_Projectids_in_projectIds166); 
            match(input,Prj,FOLLOW_Prj_in_projectIds168); 

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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:77:1: resourceDeclaration : Resource Identifier String ;
    public final void resourceDeclaration() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:78:2: ( Resource Identifier String )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:78:4: Resource Identifier String
            {
            match(input,Resource,FOLLOW_Resource_in_resourceDeclaration179); 
            match(input,Identifier,FOLLOW_Identifier_in_resourceDeclaration181); 
            match(input,String,FOLLOW_String_in_resourceDeclaration183); 

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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:81:1: task : Task Identifier String OpenParen ( task )* ( Start DateTimeWithTimeZone End DateTimeWithTimeZone Scheduling Asap Scheduled )* CloseParen ;
    public final void task() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:82:2: ( Task Identifier String OpenParen ( task )* ( Start DateTimeWithTimeZone End DateTimeWithTimeZone Scheduling Asap Scheduled )* CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:83:2: Task Identifier String OpenParen ( task )* ( Start DateTimeWithTimeZone End DateTimeWithTimeZone Scheduling Asap Scheduled )* CloseParen
            {
            match(input,Task,FOLLOW_Task_in_task195); 
            match(input,Identifier,FOLLOW_Identifier_in_task197); 
            match(input,String,FOLLOW_String_in_task199); 
            match(input,OpenParen,FOLLOW_OpenParen_in_task201); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:84:2: ( task )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Task) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:84:3: task
            	    {
            	    pushFollow(FOLLOW_task_in_task205);
            	    task();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:85:2: ( Start DateTimeWithTimeZone End DateTimeWithTimeZone Scheduling Asap Scheduled )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==Start) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:85:3: Start DateTimeWithTimeZone End DateTimeWithTimeZone Scheduling Asap Scheduled
            	    {
            	    match(input,Start,FOLLOW_Start_in_task212); 
            	    match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_task214); 
            	    match(input,End,FOLLOW_End_in_task217); 
            	    match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_task219); 
            	    match(input,Scheduling,FOLLOW_Scheduling_in_task222); 
            	    match(input,Asap,FOLLOW_Asap_in_task224); 
            	    match(input,Scheduled,FOLLOW_Scheduled_in_task227); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,CloseParen,FOLLOW_CloseParen_in_task232); 

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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:94:1: supplementTask returns [DefaultSupplementStatement suppStmt] : Supplement Task taskId= Identifier OpenParen (bStmt= booking )* Priority IntegerNumber CloseParen ;
    public final DefaultSupplementStatement supplementTask() throws RecognitionException {
        DefaultSupplementStatement suppStmt = null;

        Token taskId=null;
        DefaultBookingStatement bStmt = null;


        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:95:2: ( Supplement Task taskId= Identifier OpenParen (bStmt= booking )* Priority IntegerNumber CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:96:3: Supplement Task taskId= Identifier OpenParen (bStmt= booking )* Priority IntegerNumber CloseParen
            {

            			suppStmt = new DefaultSupplementStatement();
            		
            match(input,Supplement,FOLLOW_Supplement_in_supplementTask256); 
            match(input,Task,FOLLOW_Task_in_supplementTask258); 
            taskId=(Token)match(input,Identifier,FOLLOW_Identifier_in_supplementTask262); 
            suppStmt.setTaskId((taskId!=null?taskId.getText():null)); 
            match(input,OpenParen,FOLLOW_OpenParen_in_supplementTask268); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:101:2: (bStmt= booking )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==Booking) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:102:2: bStmt= booking
            	    {
            	    pushFollow(FOLLOW_booking_in_supplementTask276);
            	    bStmt=booking();

            	    state._fsp--;

            	    suppStmt.addBookingStatement( bStmt ); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match(input,Priority,FOLLOW_Priority_in_supplementTask286); 
            match(input,IntegerNumber,FOLLOW_IntegerNumber_in_supplementTask288); 
            match(input,CloseParen,FOLLOW_CloseParen_in_supplementTask291); 

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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:108:1: supplementResource : Supplement Resource Identifier OpenParen ( workinghours )+ CloseParen ;
    public final void supplementResource() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:109:2: ( Supplement Resource Identifier OpenParen ( workinghours )+ CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:110:2: Supplement Resource Identifier OpenParen ( workinghours )+ CloseParen
            {
            match(input,Supplement,FOLLOW_Supplement_in_supplementResource303); 
            match(input,Resource,FOLLOW_Resource_in_supplementResource305); 
            match(input,Identifier,FOLLOW_Identifier_in_supplementResource307); 
            match(input,OpenParen,FOLLOW_OpenParen_in_supplementResource309); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:111:2: ( workinghours )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==Workinghours) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:111:2: workinghours
            	    {
            	    pushFollow(FOLLOW_workinghours_in_supplementResource312);
            	    workinghours();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            match(input,CloseParen,FOLLOW_CloseParen_in_supplementResource316); 

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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:115:1: workinghours : Workinghours DayOfWeek ( Off | workingIntervals ) ;
    public final void workinghours() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:116:2: ( Workinghours DayOfWeek ( Off | workingIntervals ) )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:117:2: Workinghours DayOfWeek ( Off | workingIntervals )
            {
            match(input,Workinghours,FOLLOW_Workinghours_in_workinghours328); 
            match(input,DayOfWeek,FOLLOW_DayOfWeek_in_workinghours330); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:117:25: ( Off | workingIntervals )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==Off) ) {
                alt8=1;
            }
            else if ( (LA8_0==Time) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:117:26: Off
                    {
                    match(input,Off,FOLLOW_Off_in_workinghours333); 

                    }
                    break;
                case 2 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:117:30: workingIntervals
                    {
                    pushFollow(FOLLOW_workingIntervals_in_workinghours335);
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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:124:1: workingIntervals : workingInterval ( Comma workingInterval )* ;
    public final void workingIntervals() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:125:2: ( workingInterval ( Comma workingInterval )* )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:126:2: workingInterval ( Comma workingInterval )*
            {
            pushFollow(FOLLOW_workingInterval_in_workingIntervals359);
            workingInterval();

            state._fsp--;

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:126:18: ( Comma workingInterval )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==Comma) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:126:19: Comma workingInterval
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_workingIntervals362); 
            	    pushFollow(FOLLOW_workingInterval_in_workingIntervals364);
            	    workingInterval();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:129:1: workingInterval : Time Hyphen Time ;
    public final void workingInterval() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:130:2: ( Time Hyphen Time )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:130:4: Time Hyphen Time
            {
            match(input,Time,FOLLOW_Time_in_workingInterval378); 
            match(input,Hyphen,FOLLOW_Hyphen_in_workingInterval380); 
            match(input,Time,FOLLOW_Time_in_workingInterval382); 

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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:162:1: booking returns [DefaultBookingStatement stmt] : Booking resource= Identifier bt1= bookingTime ( Comma bt2= bookingTime )* ( OpenParen overtime CloseParen ) ;
    public final DefaultBookingStatement booking() throws RecognitionException {
        DefaultBookingStatement stmt = null;

        Token resource=null;
        DefaultIndBooking bt1 = null;

        DefaultIndBooking bt2 = null;


        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:163:2: ( Booking resource= Identifier bt1= bookingTime ( Comma bt2= bookingTime )* ( OpenParen overtime CloseParen ) )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:164:2: Booking resource= Identifier bt1= bookingTime ( Comma bt2= bookingTime )* ( OpenParen overtime CloseParen )
            {

            		stmt = new DefaultBookingStatement();
            	
            match(input,Booking,FOLLOW_Booking_in_booking496); 
            resource=(Token)match(input,Identifier,FOLLOW_Identifier_in_booking500); 
             stmt.setResource((resource!=null?resource.getText():null)); 
            pushFollow(FOLLOW_bookingTime_in_booking509);
            bt1=bookingTime();

            state._fsp--;

             stmt.addIndBooking(bt1); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:169:2: ( Comma bt2= bookingTime )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==Comma) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:169:3: Comma bt2= bookingTime
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_booking516); 
            	    pushFollow(FOLLOW_bookingTime_in_booking522);
            	    bt2=bookingTime();

            	    state._fsp--;

            	     stmt.addIndBooking(bt2); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:172:2: ( OpenParen overtime CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:172:3: OpenParen overtime CloseParen
            {
            match(input,OpenParen,FOLLOW_OpenParen_in_booking534); 
            pushFollow(FOLLOW_overtime_in_booking538);
            overtime();

            state._fsp--;

            match(input,CloseParen,FOLLOW_CloseParen_in_booking542); 

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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:177:1: bookingTime returns [DefaultIndBooking indBooking] : startTime= DateTimeWithTimeZone Plus bookingDuration= FloatingPointNumberDuration ;
    public final DefaultIndBooking bookingTime() throws RecognitionException {
        DefaultIndBooking indBooking = null;

        Token startTime=null;
        Token bookingDuration=null;

        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:178:2: (startTime= DateTimeWithTimeZone Plus bookingDuration= FloatingPointNumberDuration )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:179:2: startTime= DateTimeWithTimeZone Plus bookingDuration= FloatingPointNumberDuration
            {
            startTime=(Token)match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_bookingTime561); 
            match(input,Plus,FOLLOW_Plus_in_bookingTime565); 
            bookingDuration=(Token)match(input,FloatingPointNumberDuration,FOLLOW_FloatingPointNumberDuration_in_bookingTime571); 

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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:197:1: duration : FloatingPointNumber 'h' ;
    public final void duration() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:198:2: ( FloatingPointNumber 'h' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:199:2: FloatingPointNumber 'h'
            {
            match(input,FloatingPointNumber,FOLLOW_FloatingPointNumber_in_duration611); 
            match(input,H,FOLLOW_H_in_duration613); 

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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:202:1: overtime : Overtime IntegerNumber ;
    public final void overtime() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:203:2: ( Overtime IntegerNumber )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:204:2: Overtime IntegerNumber
            {
            match(input,Overtime,FOLLOW_Overtime_in_overtime625); 
            match(input,IntegerNumber,FOLLOW_IntegerNumber_in_overtime627); 

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
    public static final BitSet FOLLOW_OpenParen_in_header110 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_timeZone_in_header112 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_CloseParen_in_header114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TimeZone_in_timeZone127 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_Utc_in_timeZone129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Projectids_in_projectIds166 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Prj_in_projectIds168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Resource_in_resourceDeclaration179 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_Identifier_in_resourceDeclaration181 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_String_in_resourceDeclaration183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Task_in_task195 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_Identifier_in_task197 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_String_in_task199 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OpenParen_in_task201 = new BitSet(new long[]{0x0000000000060400L});
    public static final BitSet FOLLOW_task_in_task205 = new BitSet(new long[]{0x0000000000060400L});
    public static final BitSet FOLLOW_Start_in_task212 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_DateTimeWithTimeZone_in_task214 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_End_in_task217 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_DateTimeWithTimeZone_in_task219 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_Scheduling_in_task222 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_Asap_in_task224 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Scheduled_in_task227 = new BitSet(new long[]{0x0000000000040400L});
    public static final BitSet FOLLOW_CloseParen_in_task232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Supplement_in_supplementTask256 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_Task_in_supplementTask258 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_Identifier_in_supplementTask262 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OpenParen_in_supplementTask268 = new BitSet(new long[]{0x0000000101000000L});
    public static final BitSet FOLLOW_booking_in_supplementTask276 = new BitSet(new long[]{0x0000000101000000L});
    public static final BitSet FOLLOW_Priority_in_supplementTask286 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_IntegerNumber_in_supplementTask288 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_CloseParen_in_supplementTask291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Supplement_in_supplementResource303 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_Resource_in_supplementResource305 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_Identifier_in_supplementResource307 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OpenParen_in_supplementResource309 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_workinghours_in_supplementResource312 = new BitSet(new long[]{0x0000000004000400L});
    public static final BitSet FOLLOW_CloseParen_in_supplementResource316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Workinghours_in_workinghours328 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_DayOfWeek_in_workinghours330 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_Off_in_workinghours333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_workingIntervals_in_workinghours335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_workingInterval_in_workingIntervals359 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_Comma_in_workingIntervals362 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_workingInterval_in_workingIntervals364 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_Time_in_workingInterval378 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_Hyphen_in_workingInterval380 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_Time_in_workingInterval382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Booking_in_booking496 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_Identifier_in_booking500 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_bookingTime_in_booking509 = new BitSet(new long[]{0x0000000020000200L});
    public static final BitSet FOLLOW_Comma_in_booking516 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_bookingTime_in_booking522 = new BitSet(new long[]{0x0000000020000200L});
    public static final BitSet FOLLOW_OpenParen_in_booking534 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_overtime_in_booking538 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_CloseParen_in_booking542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DateTimeWithTimeZone_in_bookingTime561 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_Plus_in_bookingTime565 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_FloatingPointNumberDuration_in_bookingTime571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FloatingPointNumber_in_duration611 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_H_in_duration613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Overtime_in_overtime625 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_IntegerNumber_in_overtime627 = new BitSet(new long[]{0x0000000000000002L});

}