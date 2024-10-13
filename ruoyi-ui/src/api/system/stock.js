import request from '@/utils/request'

// 查询奖品库存管理列表
export function listStock(query) {
  return request({
    url: '/system/stock/list',
    method: 'get',
    params: query
  })
}

// 查询奖品库存管理详细
export function getStock(id) {
  return request({
    url: '/system/stock/' + id,
    method: 'get'
  })
}

// 新增奖品库存管理
export function addStock(data) {
  return request({
    url: '/system/stock',
    method: 'post',
    data: data
  })
}

// 修改奖品库存管理
export function updateStock(data) {
  return request({
    url: '/system/stock',
    method: 'put',
    data: data
  })
}

// 删除奖品库存管理
export function delStock(id) {
  return request({
    url: '/system/stock/' + id,
    method: 'delete'
  })
}
