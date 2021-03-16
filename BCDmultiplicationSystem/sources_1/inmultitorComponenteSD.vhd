----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 11/30/2020 12:54:20 PM
-- Design Name: 
-- Module Name: inmultitorComponenteSD - Behavioral
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

entity inmultitorComponenteSD is
Generic(n:natural:= 16);
Port (Clk, Rst, Start: in STD_LOGIC;
X, Y: in STD_LOGIC_VECTOR(n-1 downto 0);
A, Q: out STD_LOGIC_VECTOR(n-1 downto 0);
Stop: out STD_LOGIC );
end inmultitorComponenteSD;

architecture Behavioral of inmultitorComponenteSD is
signal LoadB, LoadQ, LoadQ0, C: STD_LOGIC:='0';
signal RstA, RstT, LoadT1, LoadT2, ShrA, ShrQ, ShrB: STD_LOGIC:='0';
signal Tout1,Tout2,outTout1, outTout2: STD_LOGIC := '0';
signal outSum1, Mem, auxXSum1: STD_LOGIC_VECTOR(7 downto 0);
signal outTout,Q0, outSum2, auxYSum2: STD_LOGIC_VECTOR(3 downto 0);
signal outQ, outB, outA: StD_LOGIC_VECTOR(n-1 downto 0);
begin
-- ------------- registre ---------------------------
registrulB: entity WORK.regSRRN generic map ( n => n) port map (Clk => Clk, Rst => Rst, CE => ShrB, Sri=>outB(3 downto 0),Load=>LoadB, D =>X, Q => OutB);
registrulA: entity WORK.regSRRN generic map(n => n) port map (Clk => Clk, Rst => RstA, CE => ShrA, Sri => outSum2, Load => '0',D => "0000000000000000",Q => outA);
registrulQ: entity WORK.regSRRN generic map(n => n) port map (Clk => Clk,Rst => Rst,CE => ShrQ,Sri => outA(3 downto 0),Load => LoadQ, D =>Y, Q => OutQ);
regT1: entity WORK.regFDN generic map(n=>4) port map(Clk => Clk, Rst => RstT, CE => LoadT1, D =>outSum1(7 downto 4), Q => outTout);
bistabilT2: entity WORK.regFD port map(Clk => Clk, Rst => RstT, CE => LoadT2,D => Tout2,Q => outTout2);
bistabilT1:entity WORK.regFD port map(Clk => Clk, Rst => RstT, CE => LoadT1,D => Tout1,Q => outTout1);
regQ0: entity WORK.regFDN generic map ( n => 4) port map (Clk => Clk, Rst => Rst, CE =>LoadQ0, D =>OutQ(3 downto 0), Q =>Q0);
ROM: entity WORK.rom81x8 port map (Addr1=>outB(3 downto 0), Addr2=>Q0, Data=>Mem);

-- ----------- Unitatea de control ----------------
controlUnit: entity WORK.unitateControlInmultitorCompSD port map (Clk => Clk, Rst => Rst, Start => Start, C=>C, LoadQ0=>LoadQ0, LoadB => LoadB, LoadQ => LoadQ, LoadT1=>LoadT1, LoadT2=>LoadT2, ShrA => ShrA, ShrQ=> ShrQ,ShrB => ShrB, RstA => RstA, RstT=>RstT, Stop => Stop);

-- ----------- Sumatoare -------------------------
sum1: entity WORK.sumatorSemiZecimal port map( X=>auxXSum1, Y=>outTout, S=>outSum1, Tin=>outTout1,Tout=>Tout1);
sum2: entity WORK.sumatorZecimal generic map (n=>4) port map ( X=>outSum1(3 downto 0), Y=>auxYSum2, S=>outSum2, Tin=>outTout2, Tout=>Tout2);

dataSelection: process(Clk)
begin
    if (rising_edge(Clk)) then
    if (C='1') then
        auxXSum1<= Mem;
        auxYSum2<=outA(3 downto 0);
    elsif (C='0') then
        auxXSum1<= "00000000";
        auxYSum2<="0000";
    end if;
    end if;
end process;

A<=outA;
Q<=outQ;
end Behavioral;
