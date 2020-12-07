jQuery(document).ready(function() {
  "use strict";
  //ReSharePeace Accordion Script
  var windowWidth=$(window).width();
  if (windowWidth <= 768) {
    $('.resharepeace-footer h6').click(function() {
	    $(this).parent().siblings().removeClass('open').children('ul').slideUp();
	    $(this).parent().toggleClass('open').children('ul').slideToggle();
	  });
  };
  if (windowWidth <= 768) {
    $('.header-topbar').insertAfter('.navbar > .navbar-collapse > ul');
  };

  //ReSharePeace Owl Carousel Slider Script
  $('.owl-carousel').each( function() {
    var $carousel = $(this);
    var $items = ($carousel.data('items') !== undefined) ? $carousel.data('items') : 1;
    var $items_lg = ($carousel.data('items-lg') !== undefined) ? $carousel.data('items-lg') : 1;
    var $items_md = ($carousel.data('items-md') !== undefined) ? $carousel.data('items-md') : 1;
    var $items_sm = ($carousel.data('items-sm') !== undefined) ? $carousel.data('items-sm') : 1;
    var $items_ssm = ($carousel.data('items-ssm') !== undefined) ? $carousel.data('items-ssm') : 1;
    $carousel.owlCarousel ({
      loop : ($carousel.data('loop') !== undefined) ? $carousel.data('loop') : true,
      items : $carousel.data('items'),
      margin : ($carousel.data('margin') !== undefined) ? $carousel.data('margin') : 0,
      dots : ($carousel.data('dots') !== undefined) ? $carousel.data('dots') : true,
      nav : ($carousel.data('nav') !== undefined) ? $carousel.data('nav') : false,
      navText : ["<div class='slider-no-current'><span class='current-no'></span><span class='total-no'></span></div><span class='current-monials'></span>", "<div class='slider-no-next'></div><span class='next-monials'></span>"],
      autoplay : ($carousel.data('autoplay') !== undefined) ? $carousel.data('autoplay') : false,
      autoplayTimeout : ($carousel.data('autoplay-timeout') !== undefined) ? $carousel.data('autoplay-timeout') : 5000,
      animateIn : ($carousel.data('animatein') !== undefined) ? $carousel.data('animatein') : false,
      animateOut : ($carousel.data('animateout') !== undefined) ? $carousel.data('animateout') : false,
      mouseDrag : ($carousel.data('mouse-drag') !== undefined) ? $carousel.data('mouse-drag') : true,
      autoWidth : ($carousel.data('auto-width') !== undefined) ? $carousel.data('auto-width') : false,
      autoHeight : ($carousel.data('auto-height') !== undefined) ? $carousel.data('auto-height') : false,
      center : ($carousel.data('center') !== undefined) ? $carousel.data('center') : false,
      responsiveClass: true,
      dotsEachNumber: true,
      smartSpeed: 600,
      autoplayHoverPause: true,
      responsive : {
        0 : {
          items : $items_ssm,
        },
        480 : {
          items : $items_sm,
        },
        768 : {
          items : $items_md,
        },
        992 : {
          items : $items_lg,
        },
        1200 : {
          items : $items,
        }
      }
    });
    var totLength = $('.owl-dot', $carousel).length;
    $('.total-no', $carousel).html(totLength);
    $('.current-no', $carousel).html(totLength);
    $carousel.owlCarousel();
    $('.current-no', $carousel).html(1);
    $carousel.on('changed.owl.carousel', function(event) {
      var total_items = event.page.count;
      var currentNum = event.page.index + 1;
      $('.total-no', $carousel ).html(total_items);
      $('.current-no', $carousel).html(currentNum);
    });
  });

  //ReSharePeace Animation On Scroll Script
  $('#Search').on('keyup', function() {
    var value = $(this).val().toLowerCase();
    $('#SearchList .resharepeace-search-list').filter(function() {
      $('#SearchList').slideDown();
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
    if ($(this).val().length < 1) {
      $('#SearchList').slideDown();
    }
  });

  //ReSharePeace Onclick Add, Remove, Toggle Classes Script
  $('.search-link').on('click', function() {
    $('.resharepeace-search').fadeIn();
    $('.resharepeace-search').find('.form-control').focus();
  });
  $('.search-box button').on('click', function() {
    $('.resharepeace-search').fadeOut();
    $('.resharepeace-search').find('.form-control').val('');
  });
  
  //ReSharePeace Animation Script
  $('.team-box').hover (
    function() {
      $(this).addClass('havoc-hover');
    },
    function() {
      $(this).removeClass('havoc-hover');
    }
  );

  //ReSharePeace Animtion Script
  $('.team-box').hoverdir ({
    hoverElem: '.mate-info'
  });
  //ReSharePeace Code Box Copy Script
   function copyToClipboard(text, el) {
    var copyTest = document.queryCommandSupported('copy');
    var elOriginalText = el.attr('data-original-title');

    if (copyTest === true) {
      var copyTextArea = document.createElement("textarea");
      copyTextArea.value = text;
      document.body.appendChild(copyTextArea);
      copyTextArea.select();
      try {
        var successful = document.execCommand('copy');
        var msg = successful ? 'Copied!' : 'Whoops, not copied!';
        el.attr('data-original-title', msg).tooltip('show');
      } catch (err) {
        console.log('Oops, unable to copy');
      }
      document.body.removeChild(copyTextArea);
      el.attr('data-original-title', elOriginalText);
    } else {
      // Fallback if browser doesn't support .execCommand('copy')
      //window.prompt("Copy to clipboard: Ctrl+C or Command+C, Enter", text);
    }
  }

  //ReSharePeace Tooltip Scripts
  $('.js-tooltip').tooltip();
 
  //ReSharePeace Copy To Clipboard Scripts
  $('.js-tooltip').click(function() {
    var text = $(this).parents('.code-box-copy').children('.copy-clipboard').text();
    var el = $(this);
    copyToClipboard(text, el);
  });

  //ReSharePeace Smooth Scroll Scripts
  $('.menu-scroll li a').mPageScroll2id ({
    offset: 100,
    scrollSpeed: 1500,
  });

  //ReSharePeace mCustomScrollbar Scripts
  $('.resharepeace-scroll').mCustomScrollbar ({
    mouseWheelPixels: 150,
    scrollInertia: 500,
  });

  //ReSharePeace Sticky Scripts
  $('.resharepeace-sticky').sticky ({
    topSpacing: 0,
    zIndex: 4
  });

  //ReSharePeace Toggle Class Script
  $('.aside-toggle').click(function() {
    $(this).parents('.resharepeace-sidebar').toggleClass('aside-open');
    $('body').toggleClass('manage-page');
  });

  //ReSharePeace Outside Click Remove Classe's Script
  $(document).on('click', function(e) {
    if ($(e.target).is('.resharepeace-aside, .resharepeace-aside *, .aside-toggle, .aside-toggle *') === false) {
      $('body').removeClass('manage-page');
      $('.resharepeace-sidebar').removeClass('aside-open');
    }
  });

  //ReSharePeace Masonry Script
  var $grid = $('.resharepeace-masonry').isotope ({
  itemSelector: '.masonry-item',
  layoutMode: 'packery',
  percentPosition: true,
  isFitWidth: true,
});
});