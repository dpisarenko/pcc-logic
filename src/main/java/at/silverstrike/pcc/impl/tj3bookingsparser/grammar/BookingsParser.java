// $ANTLR 3.2 Sep 23, 2009 14:05:07 src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g 2011-09-05 00:19:40
 

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Project", "Prj", "String", "DateTimeWithTimeZone", "Hyphen", "OpenParen", "TimeZone", "ScenarioPart1", "ScenarioPart2", "CloseParen", "Projectids", "Resource", "Identifier", "Task", "Start", "End", "Scheduling", "Asap", "Scheduled", "Supplement", "Priority", "IntegerNumber", "Workinghours", "DayOfWeek", "Off", "Comma", "Time", "Colon", "Booking", "Plus", "FloatingPointNumberDuration", "FloatingPointNumber", "Overtime", "Complete", "D", "P", "H", "A", "Space"
    };
    public static final int D=38;
    public static final int Scheduled=22;
    public static final int End=19;
    public static final int FloatingPointNumberDuration=34;
    public static final int Start=18;
    public static final int A=41;
    public static final int Prj=5;
    public static final int CloseParen=13;
    public static final int IntegerNumber=25;
    public static final int Supplement=23;
    public static final int H=40;
    public static final int DayOfWeek=27;
    public static final int DateTimeWithTimeZone=7;
    public static final int Time=30;
    public static final int Colon=31;
    public static final int P=39;
    public static final int EOF=-1;
    public static final int FloatingPointNumber=35;
    public static final int Project=4;
    public static final int TimeZone=10;
    public static final int Identifier=16;
    public static final int Space=42;
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
    public static final int ScenarioPart1=11;
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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:53:1: header : Project Prj String String DateTimeWithTimeZone Hyphen DateTimeWithTimeZone OpenParen TimeZone String ScenarioPart1 OpenParen ScenarioPart2 CloseParen CloseParen ;
    public final void header() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:54:2: ( Project Prj String String DateTimeWithTimeZone Hyphen DateTimeWithTimeZone OpenParen TimeZone String ScenarioPart1 OpenParen ScenarioPart2 CloseParen CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:55:2: Project Prj String String DateTimeWithTimeZone Hyphen DateTimeWithTimeZone OpenParen TimeZone String ScenarioPart1 OpenParen ScenarioPart2 CloseParen CloseParen
            {
            match(input,Project,FOLLOW_Project_in_header96); 
            match(input,Prj,FOLLOW_Prj_in_header98); 
            match(input,String,FOLLOW_String_in_header100); 
            match(input,String,FOLLOW_String_in_header102); 
            match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_header104); 
            match(input,Hyphen,FOLLOW_Hyphen_in_header106); 
            match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_header108); 
            match(input,OpenParen,FOLLOW_OpenParen_in_header110); 
            match(input,TimeZone,FOLLOW_TimeZone_in_header112); 
            match(input,String,FOLLOW_String_in_header114); 
            match(input,ScenarioPart1,FOLLOW_ScenarioPart1_in_header118); 
            match(input,OpenParen,FOLLOW_OpenParen_in_header120); 
            match(input,ScenarioPart2,FOLLOW_ScenarioPart2_in_header122); 
            match(input,CloseParen,FOLLOW_CloseParen_in_header124); 
            match(input,CloseParen,FOLLOW_CloseParen_in_header128); 

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
            match(input,Projectids,FOLLOW_Projectids_in_projectIds175); 
            match(input,Prj,FOLLOW_Prj_in_projectIds177); 

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
            match(input,Resource,FOLLOW_Resource_in_resourceDeclaration188); 
            match(input,Identifier,FOLLOW_Identifier_in_resourceDeclaration190); 
            match(input,String,FOLLOW_String_in_resourceDeclaration192); 

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
            match(input,Task,FOLLOW_Task_in_task204); 
            match(input,Identifier,FOLLOW_Identifier_in_task206); 
            match(input,String,FOLLOW_String_in_task208); 
            match(input,OpenParen,FOLLOW_OpenParen_in_task210); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:86:2: ( task )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Task) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:86:3: task
            	    {
            	    pushFollow(FOLLOW_task_in_task214);
            	    task();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:87:2: ( Start DateTimeWithTimeZone End DateTimeWithTimeZone Scheduling Asap Scheduled )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==Start) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:87:3: Start DateTimeWithTimeZone End DateTimeWithTimeZone Scheduling Asap Scheduled
            	    {
            	    match(input,Start,FOLLOW_Start_in_task221); 
            	    match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_task223); 
            	    match(input,End,FOLLOW_End_in_task226); 
            	    match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_task228); 
            	    match(input,Scheduling,FOLLOW_Scheduling_in_task231); 
            	    match(input,Asap,FOLLOW_Asap_in_task233); 
            	    match(input,Scheduled,FOLLOW_Scheduled_in_task236); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,CloseParen,FOLLOW_CloseParen_in_task241); 

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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:96:1: supplementTask returns [DefaultSupplementStatement suppStmt] : Supplement Task taskId= Identifier OpenParen (bStmt= booking )* Priority IntegerNumber CloseParen ;
    public final DefaultSupplementStatement supplementTask() throws RecognitionException {
        DefaultSupplementStatement suppStmt = null;

        Token taskId=null;
        DefaultBookingStatement bStmt = null;


        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:97:2: ( Supplement Task taskId= Identifier OpenParen (bStmt= booking )* Priority IntegerNumber CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:98:3: Supplement Task taskId= Identifier OpenParen (bStmt= booking )* Priority IntegerNumber CloseParen
            {

            			suppStmt = new DefaultSupplementStatement();
            		
            match(input,Supplement,FOLLOW_Supplement_in_supplementTask265); 
            match(input,Task,FOLLOW_Task_in_supplementTask267); 
            taskId=(Token)match(input,Identifier,FOLLOW_Identifier_in_supplementTask271); 
            suppStmt.setTaskId((taskId!=null?taskId.getText():null)); 
            match(input,OpenParen,FOLLOW_OpenParen_in_supplementTask277); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:103:2: (bStmt= booking )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==Booking) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:104:2: bStmt= booking
            	    {
            	    pushFollow(FOLLOW_booking_in_supplementTask285);
            	    bStmt=booking();

            	    state._fsp--;

            	    suppStmt.addBookingStatement( bStmt ); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match(input,Priority,FOLLOW_Priority_in_supplementTask295); 
            match(input,IntegerNumber,FOLLOW_IntegerNumber_in_supplementTask297); 
            match(input,CloseParen,FOLLOW_CloseParen_in_supplementTask300); 

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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:110:1: supplementResource : Supplement Resource Identifier OpenParen ( workinghours )+ CloseParen ;
    public final void supplementResource() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:111:2: ( Supplement Resource Identifier OpenParen ( workinghours )+ CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:112:2: Supplement Resource Identifier OpenParen ( workinghours )+ CloseParen
            {
            match(input,Supplement,FOLLOW_Supplement_in_supplementResource312); 
            match(input,Resource,FOLLOW_Resource_in_supplementResource314); 
            match(input,Identifier,FOLLOW_Identifier_in_supplementResource316); 
            match(input,OpenParen,FOLLOW_OpenParen_in_supplementResource318); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:113:2: ( workinghours )+
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
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:113:2: workinghours
            	    {
            	    pushFollow(FOLLOW_workinghours_in_supplementResource321);
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

            match(input,CloseParen,FOLLOW_CloseParen_in_supplementResource325); 

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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:117:1: workinghours : Workinghours DayOfWeek ( Off | workingIntervals ) ;
    public final void workinghours() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:118:2: ( Workinghours DayOfWeek ( Off | workingIntervals ) )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:119:2: Workinghours DayOfWeek ( Off | workingIntervals )
            {
            match(input,Workinghours,FOLLOW_Workinghours_in_workinghours337); 
            match(input,DayOfWeek,FOLLOW_DayOfWeek_in_workinghours339); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:119:25: ( Off | workingIntervals )
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
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:119:26: Off
                    {
                    match(input,Off,FOLLOW_Off_in_workinghours342); 

                    }
                    break;
                case 2 :
                    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:119:30: workingIntervals
                    {
                    pushFollow(FOLLOW_workingIntervals_in_workinghours344);
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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:126:1: workingIntervals : workingInterval ( Comma workingInterval )* ;
    public final void workingIntervals() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:127:2: ( workingInterval ( Comma workingInterval )* )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:128:2: workingInterval ( Comma workingInterval )*
            {
            pushFollow(FOLLOW_workingInterval_in_workingIntervals368);
            workingInterval();

            state._fsp--;

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:128:18: ( Comma workingInterval )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==Comma) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:128:19: Comma workingInterval
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_workingIntervals371); 
            	    pushFollow(FOLLOW_workingInterval_in_workingIntervals373);
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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:131:1: workingInterval : Time Hyphen Time ;
    public final void workingInterval() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:132:2: ( Time Hyphen Time )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:132:4: Time Hyphen Time
            {
            match(input,Time,FOLLOW_Time_in_workingInterval387); 
            match(input,Hyphen,FOLLOW_Hyphen_in_workingInterval389); 
            match(input,Time,FOLLOW_Time_in_workingInterval391); 

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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:164:1: booking returns [DefaultBookingStatement stmt] : Booking resource= Identifier bt1= bookingTime ( Comma bt2= bookingTime )* ( OpenParen overtime CloseParen ) ;
    public final DefaultBookingStatement booking() throws RecognitionException {
        DefaultBookingStatement stmt = null;

        Token resource=null;
        DefaultIndBooking bt1 = null;

        DefaultIndBooking bt2 = null;


        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:165:2: ( Booking resource= Identifier bt1= bookingTime ( Comma bt2= bookingTime )* ( OpenParen overtime CloseParen ) )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:166:2: Booking resource= Identifier bt1= bookingTime ( Comma bt2= bookingTime )* ( OpenParen overtime CloseParen )
            {

            		stmt = new DefaultBookingStatement();
            	
            match(input,Booking,FOLLOW_Booking_in_booking505); 
            resource=(Token)match(input,Identifier,FOLLOW_Identifier_in_booking509); 
             stmt.setResource((resource!=null?resource.getText():null)); 
            pushFollow(FOLLOW_bookingTime_in_booking518);
            bt1=bookingTime();

            state._fsp--;

             stmt.addIndBooking(bt1); 
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:171:2: ( Comma bt2= bookingTime )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==Comma) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:171:3: Comma bt2= bookingTime
            	    {
            	    match(input,Comma,FOLLOW_Comma_in_booking525); 
            	    pushFollow(FOLLOW_bookingTime_in_booking531);
            	    bt2=bookingTime();

            	    state._fsp--;

            	     stmt.addIndBooking(bt2); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:174:2: ( OpenParen overtime CloseParen )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:174:3: OpenParen overtime CloseParen
            {
            match(input,OpenParen,FOLLOW_OpenParen_in_booking543); 
            pushFollow(FOLLOW_overtime_in_booking547);
            overtime();

            state._fsp--;

            match(input,CloseParen,FOLLOW_CloseParen_in_booking551); 

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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:179:1: bookingTime returns [DefaultIndBooking indBooking] : startTime= DateTimeWithTimeZone Plus bookingDuration= FloatingPointNumberDuration ;
    public final DefaultIndBooking bookingTime() throws RecognitionException {
        DefaultIndBooking indBooking = null;

        Token startTime=null;
        Token bookingDuration=null;

        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:180:2: (startTime= DateTimeWithTimeZone Plus bookingDuration= FloatingPointNumberDuration )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:181:2: startTime= DateTimeWithTimeZone Plus bookingDuration= FloatingPointNumberDuration
            {
            startTime=(Token)match(input,DateTimeWithTimeZone,FOLLOW_DateTimeWithTimeZone_in_bookingTime570); 
            match(input,Plus,FOLLOW_Plus_in_bookingTime574); 
            bookingDuration=(Token)match(input,FloatingPointNumberDuration,FOLLOW_FloatingPointNumberDuration_in_bookingTime580); 

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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:199:1: duration : FloatingPointNumber 'h' ;
    public final void duration() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:200:2: ( FloatingPointNumber 'h' )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:201:2: FloatingPointNumber 'h'
            {
            match(input,FloatingPointNumber,FOLLOW_FloatingPointNumber_in_duration620); 
            match(input,H,FOLLOW_H_in_duration622); 

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
    // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:204:1: overtime : Overtime IntegerNumber ;
    public final void overtime() throws RecognitionException {
        try {
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:205:2: ( Overtime IntegerNumber )
            // src\\main\\java\\at\\silverstrike\\pcc\\impl\\tj3bookingsparser\\grammar\\Bookings.g:206:2: Overtime IntegerNumber
            {
            match(input,Overtime,FOLLOW_Overtime_in_overtime634); 
            match(input,IntegerNumber,FOLLOW_IntegerNumber_in_overtime636); 

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
    public static final BitSet FOLLOW_OpenParen_in_header110 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_TimeZone_in_header112 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_String_in_header114 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ScenarioPart1_in_header118 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OpenParen_in_header120 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ScenarioPart2_in_header122 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CloseParen_in_header124 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CloseParen_in_header128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Projectids_in_projectIds175 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Prj_in_projectIds177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Resource_in_resourceDeclaration188 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_Identifier_in_resourceDeclaration190 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_String_in_resourceDeclaration192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Task_in_task204 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_Identifier_in_task206 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_String_in_task208 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OpenParen_in_task210 = new BitSet(new long[]{0x0000000000062000L});
    public static final BitSet FOLLOW_task_in_task214 = new BitSet(new long[]{0x0000000000062000L});
    public static final BitSet FOLLOW_Start_in_task221 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_DateTimeWithTimeZone_in_task223 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_End_in_task226 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_DateTimeWithTimeZone_in_task228 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_Scheduling_in_task231 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_Asap_in_task233 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Scheduled_in_task236 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_CloseParen_in_task241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Supplement_in_supplementTask265 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_Task_in_supplementTask267 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_Identifier_in_supplementTask271 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OpenParen_in_supplementTask277 = new BitSet(new long[]{0x0000000101000000L});
    public static final BitSet FOLLOW_booking_in_supplementTask285 = new BitSet(new long[]{0x0000000101000000L});
    public static final BitSet FOLLOW_Priority_in_supplementTask295 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_IntegerNumber_in_supplementTask297 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CloseParen_in_supplementTask300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Supplement_in_supplementResource312 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_Resource_in_supplementResource314 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_Identifier_in_supplementResource316 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OpenParen_in_supplementResource318 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_workinghours_in_supplementResource321 = new BitSet(new long[]{0x0000000004002000L});
    public static final BitSet FOLLOW_CloseParen_in_supplementResource325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Workinghours_in_workinghours337 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_DayOfWeek_in_workinghours339 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_Off_in_workinghours342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_workingIntervals_in_workinghours344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_workingInterval_in_workingIntervals368 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_Comma_in_workingIntervals371 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_workingInterval_in_workingIntervals373 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_Time_in_workingInterval387 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_Hyphen_in_workingInterval389 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_Time_in_workingInterval391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Booking_in_booking505 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_Identifier_in_booking509 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_bookingTime_in_booking518 = new BitSet(new long[]{0x0000000020000200L});
    public static final BitSet FOLLOW_Comma_in_booking525 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_bookingTime_in_booking531 = new BitSet(new long[]{0x0000000020000200L});
    public static final BitSet FOLLOW_OpenParen_in_booking543 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_overtime_in_booking547 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_CloseParen_in_booking551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DateTimeWithTimeZone_in_bookingTime570 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_Plus_in_bookingTime574 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_FloatingPointNumberDuration_in_bookingTime580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FloatingPointNumber_in_duration620 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_H_in_duration622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Overtime_in_overtime634 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_IntegerNumber_in_overtime636 = new BitSet(new long[]{0x0000000000000002L});

}