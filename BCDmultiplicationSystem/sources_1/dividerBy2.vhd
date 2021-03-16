----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 12/26/2020 03:23:36 PM
-- Design Name: 
-- Module Name: dividerBy2 - Behavioral
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
use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity dividerBy2 is
Port (
X: in STD_LOGIC_VECTOR(15 downto 0);
Y: out STD_LOGIC_VECTOR(15 downto 0));
end dividerBy2;

architecture Behavioral of dividerBy2 is
signal auxY: STD_LOGIC_VECTOR(15 downto 0);

begin

divider1: entity WORK.digitDividerBy2 port map ( X=>X(3 downto 0), Y=>X(7 downto 4), C=>auxY(3 downto 0));
divider2: entity WORK.digitDividerBy2 port map ( X=>X(7 downto 4), Y=>X(11 downto 8), C=>auxY(7 downto 4));
divider3: entity WORK.digitDividerBy2 port map ( X=>X(11 downto 8), Y=>X(15 downto 12), C=>auxY(11 downto 8));
divider4: entity WORK.digitDividerBy2 port map ( X=>X(15 downto 12), Y=>"0000", C=>auxY(15 downto 12));
Y<=auxY;
end Behavioral;
