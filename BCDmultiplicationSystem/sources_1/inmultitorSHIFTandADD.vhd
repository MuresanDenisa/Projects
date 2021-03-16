----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 11/18/2020 05:06:05 PM
-- Design Name: 
-- Module Name: inmultitorSHIFTandADD - Behavioral
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

entity inmultitorSHIFTandADD is
Generic(n:natural:= 16);
Port (Clk, Rst, Start: in STD_LOGIC;
X, Y: in STD_LOGIC_VECTOR(n-1 downto 0);
A, Q: out STD_LOGIC_VECTOR(n-1 downto 0);
Stop: out STD_LOGIC );
end inmultitorSHIFTandADD;

architecture Behavioral of inmultitorSHIFTandADD is
signal LoadA, LoadB, LoadQ,LoadQ0: STD_LOGIC:='0';
signal RstA, LoadT, ShrAQ: STD_LOGIC:='0';
signal Tout,outTout: STD_LOGIC := '0';
signal OutA, auxX, OutB, OutSum: STD_LOGIC_VECTOR(19 downto 0);
signal Q0: STD_LOGIC_VECTOR(3 downto 0);
signal OutQ:STD_LOGIC_VECTOR(n-1 downto 0);

begin
-- ------------- registre ---------------------------
auxX<="0000"&X;
registrulB: entity WORK.regFDN generic map ( n => n+4) port map (Clk => Clk, Rst => Rst, CE => LoadB, D =>auxX, Q => OutB);
registrulA: entity WORK.regSRRN generic map(n => n+4) port map (Clk => Clk, Rst => RstA, CE => ShrAQ, Sri => "0000",Load => LoadA,D => outSum,Q => outA);
registrulQ: entity WORK.regSRRN generic map(n => n) port map (Clk => Clk,Rst => Rst,CE => ShrAQ,Sri => outA(3 downto 0),Load => LoadQ,D => Y, Q => OutQ);
bistabilD: entity WORK.regFD port map(Clk => Clk, Rst => Rst, CE => LoadT,D => Tout,Q => outTout);
regQ0: entity WORK.regFDN generic map ( n => 4) port map (Clk => Clk, Rst => Rst, CE =>LoadQ0, D =>OutQ(3 downto 0), Q =>Q0);

-- -------------- SUMATOR PRODUS PARTIAL ----------------------------------
sumator: entity WORK.sumatorZecimal20biti port map( X=>OutB, Y=>outA, S=>outSum, Tin=>outTout, Tout=>Tout);

-- ----------- Unitatea de control ----------------

controlUnit: entity WORK.unitateControlinmultitorSHIFTandADD port map (Clk => Clk, Rst => Rst, Start => Start, Q0=>Q0, LoadA => LoadA, LoadQ0=>LoadQ0, LoadB => LoadB, LoadQ => LoadQ, LoadT=>LoadT, ShrAQ => ShrAQ, RstA => RstA, Stop => Stop);

A<=outA(15 downto 0);
Q<=outQ;

end Behavioral;
