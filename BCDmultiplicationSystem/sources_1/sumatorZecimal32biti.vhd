----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 12/22/2020 05:36:40 PM
-- Design Name: 
-- Module Name: sumatorZecimal32biti - Behavioral
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

entity sumatorZecimal32biti is
Generic (n: natural:=32);
Port ( X, Y: in STD_LOGIC_VECTOR(n-1 downto 0);
       S: out STD_LOGIC_VECTOR(n-1 downto 0);
       Tin: in STD_LOGIC;
       Tout: out STD_LOGIC);
end sumatorZecimal32biti;

architecture Behavioral of sumatorZecimal32biti is
signal auxTout: STD_LOGIC_VECTOR(7 downto 0);
begin

suma0: entity WORK.sumatorZecimal generic map (n=>4) port map ( X=>X(3 downto 0), Y=>Y(3 downto 0), S=>S(3 downto 0), Tin=>Tin, Tout=>auxTout(0));
suma1: entity WORK.sumatorZecimal generic map (n=>4) port map ( X=>X(7 downto 4), Y=>Y(7 downto 4), S=>S(7 downto 4), Tin=>auxTout(0), Tout=>auxTout(1));
suma2: entity WORK.sumatorZecimal generic map (n=>4) port map ( X=>X(11 downto 8), Y=>Y(11 downto 8), S=>S(11 downto 8), Tin=>auxTout(1), Tout=>auxTout(2));
suma3: entity WORK.sumatorZecimal generic map (n=>4) port map ( X=>X(15 downto 12), Y=>Y(15 downto 12), S=>S(15 downto 12), Tin=>auxTout(2), Tout=>auxTout(3));
suma4: entity WORK.sumatorZecimal generic map (n=>4) port map ( X=>X(19 downto 16), Y=>Y(19 downto 16), S=>S(19 downto 16), Tin=>auxTout(3), Tout=>auxTout(4));
suma5: entity WORK.sumatorZecimal generic map (n=>4) port map ( X=>X(23 downto 20), Y=>Y(23 downto 20), S=>S(23 downto 20), Tin=>auxTout(4), Tout=>auxTout(5));
suma6: entity WORK.sumatorZecimal generic map (n=>4) port map ( X=>X(27 downto 24), Y=>Y(27 downto 24), S=>S(27 downto 24), Tin=>auxTout(5), Tout=>auxTout(6));
suma7: entity WORK.sumatorZecimal generic map (n=>4) port map ( X=>X(31 downto 28), Y=>Y(31 downto 28), S=>S(31 downto 28), Tin=>auxTout(6), Tout=>auxTout(7));
Tout<= auxTout(7);

end Behavioral;
