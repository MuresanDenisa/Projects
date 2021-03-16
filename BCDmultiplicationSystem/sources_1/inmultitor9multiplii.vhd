----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 11/13/2020 11:25:27 AM
-- Design Name: 
-- Module Name: inmultitor9multiplii - Behavioral
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

entity inmultitor9multiplii is
Generic(n:natural:= 16);
Port (Clk, Rst, Start: in STD_LOGIC;
X, Y: in STD_LOGIC_VECTOR(n-1 downto 0);
A, Q: out STD_LOGIC_VECTOR(n-1 downto 0);
Stop: out STD_LOGIC );
end inmultitor9multiplii;

architecture Behavioral of inmultitor9multiplii is
type multiplu is array(1 to 9) of STD_LOGIC_VECTOR(19 downto 0);
signal LoadA, LoadB, LoadQ,LoadQ0: STD_LOGIC:='0';
signal RstA, LoadT, ShrAQ: STD_LOGIC:='0';
signal Tout,outTout,aux: STD_LOGIC := '0';
signal OutA, auxX, OutSum, Data: STD_LOGIC_VECTOR(19 downto 0);
signal B,OutB: multiplu := (others =>"00000000000000000000");
signal Q0: STD_LOGIC_VECTOR(3 downto 0);
signal outQ: StD_LOGIC_VECTOR(n-1 downto 0);

begin
--  ------------ generare multiplii --------------------
auxX<= "0000"&X;
multiplu1: entity WORK.sumatorZecimal20biti port map( X=>auxX, Y=>"00000000000000000000", S=>B(1), Tin=>'0', Tout=>aux);
multiplu2: entity WORK.sumatorZecimal20biti port map( X=>B(1), Y=>B(1), S=>B(2), Tin=>'0', Tout=>aux);
multiplu3: entity WORK.sumatorZecimal20biti port map( X=>B(1), Y=>B(2), S=>B(3), Tin=>'0', Tout=>aux);
multiplu4: entity WORK.sumatorZecimal20biti port map( X=>B(1), Y=>B(3), S=>B(4), Tin=>'0', Tout=>aux);
multiplu5: entity WORK.sumatorZecimal20biti port map( X=>B(1), Y=>B(4), S=>B(5), Tin=>'0', Tout=>aux);
multiplu6: entity WORK.sumatorZecimal20biti port map( X=>B(1), Y=>B(5), S=>B(6), Tin=>'0', Tout=>aux);
multiplu7: entity WORK.sumatorZecimal20biti port map( X=>B(1), Y=>B(6), S=>B(7), Tin=>'0', Tout=>aux);
multiplu8: entity WORK.sumatorZecimal20biti port map( X=>B(1), Y=>B(7), S=>B(8), Tin=>'0', Tout=>aux);
multiplu9: entity WORK.sumatorZecimal20biti port map( X=>B(1), Y=>B(8), S=>B(9), Tin=>'0', Tout=>aux);

regB1: entity WORK.regFDN generic map ( n => n+4) port map (Clk => Clk, Rst => '0', CE => LoadB, D =>B(1), Q => OutB(1));
regB2: entity WORK.regFDN generic map ( n => n+4) port map (Clk => Clk, Rst => '0', CE => LoadB, D =>B(2), Q => OutB(2));
regB3: entity WORK.regFDN generic map ( n => n+4) port map (Clk => Clk, Rst => '0', CE => LoadB, D =>B(3), Q => OutB(3));
regB4: entity WORK.regFDN generic map ( n => n+4) port map (Clk => Clk, Rst => '0', CE => LoadB, D =>B(4), Q => OutB(4));
regB5: entity WORK.regFDN generic map ( n => n+4) port map (Clk => Clk, Rst => '0', CE => LoadB, D =>B(5), Q => OutB(5));
regB6: entity WORK.regFDN generic map ( n => n+4) port map (Clk => Clk, Rst => '0', CE => LoadB, D =>B(6), Q => OutB(6));
regB7: entity WORK.regFDN generic map ( n => n+4) port map (Clk => Clk, Rst => '0', CE => LoadB, D =>B(7), Q => OutB(7));
regB8: entity WORK.regFDN generic map ( n => n+4) port map (Clk => Clk, Rst => '0', CE => LoadB, D =>B(8), Q => OutB(8));
regB9: entity WORK.regFDN generic map ( n => n+4) port map (Clk => Clk, Rst => '0', CE => LoadB, D =>B(9), Q => OutB(9));


-- ------------ comparare ---------------------
comparare: process(Q0,clk)
begin
    if rising_edge(clk) then
    case Q0 is
            when "0001" => Data<=OutB(1);
            when "0010" => Data<=OutB(2);
            when "0011" => Data<=OutB(3);
            when "0100" => Data<=OutB(4);
            when "0101" => Data<=OutB(5);
            when "0110" => Data<=OutB(6);
            when "0111" => Data<=OutB(7);
            when "1000" => Data<=OutB(8);
            when "1001" => Data<=OutB(9);
            when others => Data<= ( others=>'0');
    end case;   
   end if;
end process;         

-- -------------- SUMATOR PRODUS PARTIAL ----------------------------------
sumator: entity WORK.sumatorZecimal20biti port map( X=>Data, Y=>outA, S=>outSum, Tin=>outTout, Tout=>Tout);

-- ------------- registre ---------------------------

registrulA: entity WORK.regSRRN generic map(n => n+4) port map (Clk => Clk, Rst => RstA, CE => ShrAQ, Sri => "0000",Load => LoadA,D => outSum,Q => outA);
registrulQ: entity WORK.regSRRN generic map(n => n) port map (Clk => Clk,Rst => Rst,CE => ShrAQ,Sri => outA(3 downto 0),Load => LoadQ,D => Y, Q => OutQ);
bistabilD: entity WORK.regFD port map(Clk => Clk, Rst => Rst, CE => LoadT,D => Tout,Q => outTout);
regQ0: entity WORK.regFDN generic map ( n => 4) port map (Clk => Clk, Rst => Rst, CE =>LoadQ0, D =>OutQ(3 downto 0), Q =>Q0);

-- ----------- Unitatea de control ----------------

controlUnit: entity WORK.unitateControlinmultitor9multiplii port map (Clk => Clk, Rst => Rst, Start => Start, Q0=>Q0, LoadA => LoadA, LoadQ0=>LoadQ0, LoadB => LoadB, LoadQ => LoadQ, LoadT=>LoadT, ShrAQ => ShrAQ, RstA => RstA, Stop => Stop);

A<=outA(15 downto 0);
Q<=outQ;
end Behavioral;