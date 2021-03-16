----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 11/13/2020 05:51:19 PM
-- Design Name: 
-- Module Name: sumatorZecimal20biti - Behavioral
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

entity sumatorZecimal20biti is
Generic (n: natural:=20);
Port ( X, Y: in STD_LOGIC_VECTOR(n-1 downto 0);
       S: out STD_LOGIC_VECTOR(n-1 downto 0);
       Tin: in STD_LOGIC;
       Tout: out STD_LOGIC);
end sumatorZecimal20biti;

architecture Behavioral of sumatorZecimal20biti is
signal auxTout: STD_LOGIC_VECTOR(4 downto 0);
begin

suma0: entity WORK.sumatorZecimal generic map (n=>4) port map ( X=>X(3 downto 0), Y=>Y(3 downto 0), S=>S(3 downto 0), Tin=>Tin, Tout=>auxTout(0));
suma1: entity WORK.sumatorZecimal generic map (n=>4) port map ( X=>X(7 downto 4), Y=>Y(7 downto 4), S=>S(7 downto 4), Tin=>auxTout(0), Tout=>auxTout(1));
suma2: entity WORK.sumatorZecimal generic map (n=>4) port map ( X=>X(11 downto 8), Y=>Y(11 downto 8), S=>S(11 downto 8), Tin=>auxTout(1), Tout=>auxTout(2));
suma3: entity WORK.sumatorZecimal generic map (n=>4) port map ( X=>X(15 downto 12), Y=>Y(15 downto 12), S=>S(15 downto 12), Tin=>auxTout(2), Tout=>auxTout(3));
suma4: entity WORK.sumatorZecimal generic map (n=>4) port map ( X=>X(19 downto 16), Y=>Y(19 downto 16), S=>S(19 downto 16), Tin=>auxTout(3), Tout=>auxTout(4));
Tout<= auxTout(4);
end Behavioral;
