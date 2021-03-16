----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 11/13/2020 11:38:54 AM
-- Design Name: 
-- Module Name: sumatorZecimal - Behavioral
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

entity sumatorZecimal is
Generic (n: natural);
Port ( X, Y: in STD_LOGIC_VECTOR(n-1 downto 0);
       S: out STD_LOGIC_VECTOR(n-1 downto 0);
       Tin: in STD_LOGIC;
       Tout: out STD_LOGIC);
end sumatorZecimal;

architecture Behavioral of sumatorZecimal is
signal auxS: STD_LOGIC_VECTOR(n-1 downto 0);
signal aux: STD_LOGIC_VECTOR(n-1 downto 0);
signal auxTout0: STD_LOGIC;
signal auxTout1: STD_LOGIC;
signal aux0:STD_LOGIC;
begin

suma0: entity WORK.sumADDN generic map (n=> n) port map ( X=>X, Y=>Y, S=>auxS, Tin=>Tin, Tout=>auxTout0);
auxTout1<= auxTout0 or (auxS(1) and auxS(3)) or (auxS(2) and auxS(3));
aux<= "0110" when auxTout1='1' else "0000";
suma1: entity WORK.sumADDN generic map (n=> n) port map ( X=>auxS, Y=>AUX, S=>S, Tin=>'0', Tout=>aux0); 
Tout<=auxTout1;  
end Behavioral;
