----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 12/22/2020 05:22:34 PM
-- Design Name: 
-- Module Name: inmultitorDublariInjumatatiri - Behavioral
-- Project Name: 
-- Target Devices: 
-- Tool Versions: 
-- Description: 
-- 
-- Dependencies: 
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
-- 
----------------------------------------------------------------------------------


library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity inmultitorDublariInjumatatiri is
Generic(n:natural:= 16);
Port (Clk, Rst, Start: in STD_LOGIC;
X, Y: in STD_LOGIC_VECTOR(n-1 downto 0);
A, Q: out STD_LOGIC_VECTOR(n-1 downto 0);
Stop: out STD_LOGIC );
end inmultitorDublariInjumatatiri;

architecture Behavioral of inmultitorDublariInjumatatiri is
signal LoadX,LoadY,LoadP, LoadB, LoadQ,RstP, LoadAuxQ: STD_LOGIC:='0';
signal auxTout: STD_LOGIC := '0';
signal outB, auxX:STD_LOGIC_VECTOR(n-1 downto 0);
signal OutP,auxY, aux2Y, OutQ, auxQ, PP, outSum: STD_LOGIC_VECTOR(31 downto 0):= (others =>'0');

begin
-- ------------- registre ---------------------------
auxY<="0000000000000000"&Y;
registrulP: entity WORK.regFDN generic map ( n => n+16) port map (Clk => Clk, Rst => RstP, CE => LoadP, D =>PP, Q => OutP);
registrulB: entity WORK.regDoubleFDN generic map(n => n) port map (Clk => Clk, Rst => Rst, CE1=>LoadX, CE2 => LoadB,D1 =>X, D2=>auxX, outQ =>outB);
registrulQ: entity WORK.regDoubleFDN generic map ( n => n+16) port map (Clk => Clk, Rst => Rst, CE1=>LoadY, CE2 => LoadQ, D1 =>auxY, D2=>OutSum, outQ => OutQ);
registrulAuxQ: entity WORK.regFDN generic map ( n => n+16) port map (Clk => Clk, Rst => Rst, CE => LoadAuxQ, D =>outQ, Q => auxQ);
        
-- ------------ DIVIDER BY 2 ------------------------------------------------
dividerBy2: entity WORK.dividerBy2 port map (X=>OutB, Y=>auxX);

-- -------------- SUMATOR PRODUS PARTIAL ------------------------------------
sumator: entity WORK.sumatorZecimal32biti port map( X=>outP, Y=>auxQ, S=>PP, Tin=>'0', Tout=>auxTout);

-- -------------- SUMATOR DUBLARE INMULTITOR ----------------------------------
sumator1: entity WORK.sumatorZecimal32biti port map( X=>OutQ, Y=>outQ, S=>OutSum, Tin=>'0', Tout=>auxTout);

-- ----------- Unitatea de control ----------------
controlUnit: entity WORK.unitateControlInmultitorDublariInjumatatiri port map (Clk => Clk, Rst => Rst, Start => Start,B=>outB,LoadX=>LoadX, LoadY=>LoadY, LoadAuxQ=>LoadAuxQ,LoadP => LoadP, LoadB => LoadB, LoadQ => LoadQ, RstP => RstP, Stop => Stop);
A<= PP(31 downto 16);
Q<=PP(15 downto 0);
end Behavioral;
